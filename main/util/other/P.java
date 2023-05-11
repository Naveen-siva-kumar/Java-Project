	import java.awt.*;

	import java.awt.event.*;

	import javax.swing.*;

	import javax.swing.event.*;

	import java.awt.Graphics.*;

	 

	 

	public class P

	{
	    public static void main(String args[])
	    {

	        JFrame  f;

	        f=new PaintExampleFrame();

	        f.setVisible(true);

	    }

	 

	 

	}

	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	class PaintExampleFrame extends JFrame

	{

	 

	PaintExampleFrame()

	{

	 //   System.out.println("Yay");

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    setTitle("Paint Attempts");

	    setSize(500,500);

	    setLocation(new Point(5,5));

	    setVisible(true);

	    setBackground(Color.black);

	 

	}

	 

	public void paint(Graphics g)

	        {

	            g.setColor(Color.red);

	            g.drawLine(0,0,200,200);

	            g.setColor(Color.blue);

	            g.drawLine(200,200,70,133);

	            g.setColor(Color.orange);

	            g.drawLine(7,798,400,15);

	    }

	 

	 

	}

