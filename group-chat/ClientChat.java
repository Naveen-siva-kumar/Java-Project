/**
 * naveen
 */
/*import java.net.*; 
import javax.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*; 
//import java.net.*;
import java.util.*;
import  java.nio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClientChat extends JFrame implements ActionListener{
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
    		//public String userName = null;
    		String uname;
    		PrintWriter pw;
    		BufferedReader br;
    		JTextArea  taMessages;
    		JTextField tfInput;
    		JButton btnSend,btnExit;
    		Socket client;
    		String name;
    		JPanel bp;
    	public ClientChat(){}
	public static void main(String[] args){
		
    		String userName = null;
 
		String string="";
		String res = "";
		
		try{
		
			
			Socket s = new Socket("10.0.3.159",4412);
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			
			userName = Validator.getString("ENter your name  :");//out.println("-EOF-");
			
			String response ="";
			out.println("userName");
			out.flush();
			do{	
						
				do{
				   response=r.readLine();
				   if(!response.equals("-EOF-"))
				   System.out.println(ANSI_WHITE+response+ANSI_GREEN);
				  
				}while(!response.equals("-EOF-") && !response.equals("bye") && !response.equals("image") && !response.equals("chat"));
				if(response.equals("bye"))
					break;
					
				else if(response.equals("chat")){
				// do{
				try{
				    ClientChat cc= new ClientChat();
				    cc.chat(s);
				 }catch(IOException ex){}
				 //}while(!res.equals("bye-bye"));
			       }
				string=Validator.getString("");
				out.println(string);
				out.flush();
				
			
			      
				
			}while(true);//while(!response.equals("bye"));
				
			
			s.close();
		}
		
		catch(UnknownHostException u){
			System.out.println(ANSI_RED + "Sorry there is no host with that ip address and the port " +ANSI_RESET);
		}
		
		catch(IOException e){
			//s.close();
			System.out.println(ANSI_RED+"Server is not on"+ANSI_RESET);
		}
			
            		
        		
        	
   }//////////////////main close      ////////////////////////
       

   private void chat(Socket s)throws IOException{
   	String n = JOptionPane.showInputDialog(null,"Enter your name :", "Username",
             JOptionPane.PLAIN_MESSAGE);
        this.name = n;
        ClientChat(n,s);
   }
   private void ClientChat(String n,Socket s){
    	super(n);
        this.uname = n;
        //client  = new Socket(servername,9999);
        br = new BufferedReader( new InputStreamReader( s.getInputStream()) ) ;
        pw = new PrintWriter(s.getOutputStream(),true);
        pw.println(uname);  // send name to server
        buildInterface();
        new MessagesThread().start();
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
        this.bp = new JPanel( new FlowLayout());
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
            System.exit(0);
        } else {
            // send message to server
            pw.println(tfInput.getText());
        }
    }	
    class  MessagesThread extends Thread {
        public void run() {
            String line;
            try {
                while(true) {
                    line = br.readLine();
                    taMessages.append(line + "\n");
                } // end of while
            } catch(Exception ex) {}
        }
    }
}*/
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.System.out;
public class  ClientChat extends JFrame implements ActionListener {
    String uname;
    PrintWriter pw;
    BufferedReader br;
    JTextArea  taMessages;
    JTextField tfInput;
    JButton btnSend,btnExit;
    Socket client;
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
        //client  = new Socket("10.0.3.159",4412);
        client  = new Socket("10.110.21.51",4412);
        br = new BufferedReader( new InputStreamReader( client.getInputStream()) ) ;
        pw = new PrintWriter(client.getOutputStream(),true);
        
        pw.println(uname);  // send name to server
        try{
        clientStart(client);
        }catch(IOException b){}
        //buildInterface();
        //new MessagesThread().start();  // create thread to listen for messages
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
            System.exit(0);
        } else {
            // send message to server
            pw.println(tfInput.getText());
        }
    }
    
    public static void main(String ... args) {
    
        // take username from user
        String name = JOptionPane.showInputDialog(null,"Enter your name :", "Username",
             JOptionPane.PLAIN_MESSAGE);
        //String servername = "10.0.3.159";  
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
					
				else if(response.equals("chat")){
				// do{
				//try{
				    buildInterface();
        			    new MessagesThread().start(); 
				    //ClientChat cc= new ClientChat();
				    //cc.chat(s);
				// }catch(IOException ex){}
				 //}while(!res.equals("bye-bye"));
			       }//System.out.println("_____________________");
				string=Validator.getString("");
				//System.out.println("_____________________");
				out.println(string);
				out.flush();
				//System.out.println("_____________________");
			
			      
				
			}while(true);//while(!response.equals("bye"));
				
			
			s.close();
    }
    // inner class for Messages Thread
    class  MessagesThread extends Thread {
        public void run() {
            String line;
            try {
                while(true) {
                    line = br.readLine();
                    taMessages.append(line + "\n");
                } // end of while
            } catch(Exception ex) {}
        }
    }
} //  end of clientChat
