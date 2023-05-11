/**
 * naveen
 */
package client;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*; 
import javax.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*; 
import  java.nio.*;
import static java.lang.System.out;


public class  ClientChat extends JFrame implements ActionListener {
    String uname;
    PrintWriter pw;
    BufferedReader br;
    JTextArea  taMessages;
    JTextField tfInput;
    JButton btnSend,btnExit;
    Socket client;
    JPanel jp;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";	
    public static final String GREEN_B = "\033[0;92m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public ClientChat(String uname) throws Exception {
        super(uname);  // set title for frame
        this.uname = uname;
        client  = new Socket("10.0.3.159",4412);
        br = new BufferedReader( new InputStreamReader( client.getInputStream()) ) ;
        pw = new PrintWriter(client.getOutputStream(),true);
        
        pw.println(uname);  // send name to server
        try{
        clientStart(client);
        }catch(IOException b){}
        
    }
    
    public void buildInterface() {
        btnSend = new JButton("Send");
        btnExit = new JButton("Exit");
        taMessages = new JTextArea();
        taMessages.setRows(10);
        taMessages.setColumns(50);
        taMessages.setEditable(false);
        tfInput  = new JTextField(50);
        JScrollPane sp = new JScrollPane(taMessages, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sp,"Center");
        JPanel bp = new JPanel( new FlowLayout());
        this.jp = bp;
        bp.add(tfInput);
        bp.add(btnSend);
        bp.add(btnExit);
        add(bp,"South");
        btnSend.addActionListener(this);
        btnExit.addActionListener(this);
        setSize(500,300);
        setVisible(true);
        pack();
    }
    
    public void actionPerformed(ActionEvent evt) {
        if ( evt.getSource() == btnExit ) {
            pw.println("end");  // send end to server so that server knows about the termination
            //jp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //setVisible(false);//jp.dispose();
            //pw.close();
            System.exit(0);
            return ;
        } else {
            // send message to server
            pw.println(tfInput.getText());
        }
    }
    
    public static void main(String ... args) {
    
        
        String name = JOptionPane.showInputDialog(null,"Enter your name :", "Username",
             JOptionPane.PLAIN_MESSAGE);
          
        try {
            new ClientChat( name);
        } catch(Exception ex) {
            out.println( "Error --> " + ex.getMessage());
        }
        
    } // end of main
   			
   private void clientStart(Socket s) throws IOException{
   		String userName = null;
    		String response = "";
		String string="";
		String res = "";
		BufferedReader r = new BufferedReader( new InputStreamReader( client.getInputStream()) ) ;
        	PrintWriter out = new PrintWriter(client.getOutputStream());		 
   			 do{	
						
				do{
				   response=r.readLine();
				   if(!response.equals("-EOF-"))
				   System.out.println(ANSI_WHITE+response+ANSI_GREEN);
				  
				}while(!response.equals("-EOF-") && !response.equals("bye") && !response.equals("image") && !response.equals("chat"));
				if(response.equals("bye"))
					break;
				else if(response.equals("image")){
					try{
						
						InputStream inputStream = s.getInputStream();
		
						byte[] sizeAr = new byte[4];
        					inputStream.read(sizeAr);
						int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

						byte[] imageAr = new byte[size];
						inputStream.read(imageAr);

						BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

						ImageIO.write(image, "jpeg", new File("gottheimage.jpeg"));
		
						DisplayImage.display();
					}catch(Exception e ){}
					
								
				
				}	
				else if(response.equals("chat")){
				
				    buildInterface();
        			    new MessagesThread().start(); 
				    
			       }
				string=Validator.getString("");
				
				out.println(string);
				out.flush();
				
			
			      
				
			}while(true);
				
			
			s.close();
    }
    
    class  MessagesThread extends Thread {
        public void run() {
            String line;
            try {
                while(true) {
                    line = br.readLine();
                    taMessages.append(line + "\n");
                } 
            } catch(Exception ex) {}
        }
    }
} //  end of clientChat
