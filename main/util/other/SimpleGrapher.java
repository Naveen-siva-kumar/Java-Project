

    /*
       The SimpleGrapher applet can draw graphs of functions input by the
       user.  The user enters the definition of the function in a text
       input box.  When the user presses return, the function is graphed.
       (Unless the definition contains an error.  In that case, an error
       message is displayed.)
       
       The graph is drawn on a canvas which represents the region of the
       (x,y)-plane given by  -5 <= x <= 5  and  -5 <= y <= 5.  Any part of
       the graph that lies outside this region is not shown.  The graph
       is drawn by plotting 301 points and joining them with lines.  This
       does not handle discontinuous functions properly.
    
       This file defines two classes, the main applet class, SimpleGrapher,
       and a canvas class, SimpleGrapherCanvas, with is used by the applet.
       It depends on the class Expr, which is defined in a separate file,
       Expr.java.  That file contains a full description of the syntax
       of legal function definitions.
    */
    
    
    import java.awt.*;
    import java.awt.event.*;
    import java.applet.Applet;
    
    
    public class SimpleGrapher extends Applet implements ActionListener{
    
       SimpleGrapherCanvas graph;  // The canvas that will display the graph.
                                   // The SimpleGrapherCanvas is defined below.
                                   
       TextField functionInput;  // A text input box where the user enters the
                                 // definition of the function.
       
       Label message;  // A label for displaying messages to the user,
                       // including error messages when the function definition
                       // is illegal.
       
       public void init() {
             // Initialize the applet by creating and laying out the
             // components.  The applet listens for ActionEvents from
             // the text input box, so that it can respond when the
             // user presses return.
       
          setBackground(Color.gray);
          setLayout(new BorderLayout(5,5));
          
          graph = new SimpleGrapherCanvas();
          add(graph, BorderLayout.CENTER);
          
          message = new Label(" Enter a function and press return");
          message.setBackground(Color.white);
          message.setForeground(Color.red);
          add(message, BorderLayout.NORTH);
          
          functionInput = new TextField();
          functionInput.setBackground(Color.white);
          functionInput.addActionListener(this);
          add(functionInput, BorderLayout.SOUTH);
          
       }  // end init()
       
       public Insets getInsets() {
            // Specify a 5-pixel border around the edges of the applet.
          return new Insets(5,5,5,5);
       }
       
       public void actionPerformed(ActionEvent evt) {
            // This will be called when the user presses return in
            // the text input box.  Get the user's function definition
            // from the box and use it to create a new object of type
            // Expr.  Tell the canvas to graph this function.  If the
            // definition is illegal, an IllegalArgumentException is
            // thrown by the Expr constructor.  If this happens,
            // the graph is cleared and an error message is displayed
            // in the message label.
            
          Expr function;  // The user's function.
            
          try {
              String def = functionInput.getText();
              function = new Expr(def);
              graph.setFunction(function);
              message.setText(" Enter a function and press return.");
          }
          catch (IllegalArgumentException e) {
              graph.clearFunction();
              message.setText(e.getMessage());
          }
    
       }  // end actionPerformed()
    
    } // end class SimpleGrapher
    
    
    class SimpleGrapherCanvas extends Canvas {
    
       // A SimpleGrapherCanvas can display the graph of a function
       // on the region of the (x,y)-plane given by -5 <= x <= 5 and
       // -5 <= y <= 5.  The graph is drawn very simply, by plotting
       // 301 points and connecting them with line segments.
       
    
       Expr func;  // The definition of the function that is to be graphed.
                   // If the value is null, no graph is drawn.
    
    
       SimpleGrapherCanvas() {
             // Constructor.
          setBackground(Color.white);
          func = null;
       }
       
    
       public void setFunction(Expr exp) {
             // Set the canvas to graph the function whose definition is
             // given by the function exp.
          func = exp;
          repaint();
       }
       
    
       public void clearFunction() {
             // Set the canvas to draw no graph at all.
          func = null;
          repaint();
       }
       
    
       public void paint(Graphics g) {
             // Draw the graph of the function or, if func is null, 
             // display a message that there is no function to be graphed.
          if (func == null) {
             g.drawString("No function is available.", 20, 30);
          }
          else {
             g.drawString("y = " + func.getDefinition(), 5, 15);
             drawAxes(g);
             drawFunction(g);
          }
       }
       
    
       void drawAxes(Graphics g) {
             // Draw horizontal and vertical axes in the middle of the
             // canvas.  A 5-pixel border is left at the ends of the axes.
          int width = getSize().width;
          int height = getSize().height;
          g.setColor(Color.blue);
          g.drawLine(5, height/2, width-5, height/2);
          g.drawLine(width/2, 5, width/2, height-5);
       }
       
    
       void drawFunction(Graphics g) {
            // Draw the graph of the function defined by the instance variable func.
            // Just plot 301 points with lines between them. 
            
          double x, y;          // A point on the graph.  y is f(x).
          double prevx, prevy;  // The previous point on the graph.
          
          double dx;  // Difference between the x-values of consecutive points
                      //    on the graph.
          
          dx  = 10.0 / 300;
          
          g.setColor(Color.red);
          
          /* Compute the first point. */
          
          x = -5;
          y = func.value(x);
          
          /* Compute each of the other 300 points, and draw a line segment
             between each consecutive pair of points.  Note that if the function
             is undefined at one of the points in a pair, then the line 
             segment is not drawn.  */
          
          for (int i = 1; i <= 300; i++) {
          
             prevx = x;           // Save the coords of the previous point.
             prevy = y;
             
             x += dx;            // Get the coords of the next point.
             y = func.value(x);
             
             if ( (! Double.isNaN(y)) && (! Double.isNaN(prevy)) ) {
                   // Draw a line segment between the two points.
                putLine(g, prevx, prevy, x, y);
             }
                
          }  // end for
          
       }  // end drawFunction()
    
       
       void putLine(Graphics g, double x1, double y1, double x2, double y2) {
             // Draw a line segment from the point (x1,y1) to (x2,y2).  These
             // real values must be scaled to get the integer coordinates of
             // the corresponding pixels.
             
          int a1, b1;   // Pixel coordinates corresponding to (x1,y1).
          int a2, b2;   // Pixel coordinates corresponding to (x2,y2).
          
          int width = getSize().width;     // Width of the canvas.
          int height = getSize().height;   // Height of the canvas. 
          
          a1 = (int)( (x1 + 5) / 10 * width );
          b1 = (int)( (5 - y1) / 10 * height );
          a2 = (int)( (x2 + 5) / 10 * width );
          b2 = (int)( (5 - y2) / 10 * height );
          
          g.drawLine(a1,b1,a2,b2);
          
       }  // end putLine()
    
    }  // end class SimpleGrapherCanvas

