import java.io.*;
import java.net.*;
import java.util.*;
import java.net.*; 
import java.util.*;
import java.io.*;
import java.lang.*;//import java.net.*;
//import java.util.*;
import  java.nio.*;
//import  java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.image.*; 
/**
 * naveen
 */
public class Server {
    public Server(){}
    //private Set<String> userNames = new HashSet<>();
   // private Set<ServerClientThread> userThreads = new HashSet<>();
    Vector<String> users = new Vector<String>();
    Vector<ServerClientThread> clients = new Vector<ServerClientThread>();
    
   
    public static void main(String[] args){
    		//int counter=0;
    		Server s = new Server();
    		s.createThread();
		
    }
 
    
 
     private void createThread(){
     	int counter=0;
     	String name = "";
     	try{	
		ServerSocket ss = new ServerSocket(4412);
		while(true){
        		counter++;
        		Socket s=ss.accept();  //server accept the client connection request
        		System.out.println(" >> " + "Client No:" + counter + " started!");
        		try{
        		
        		ServerClientThread c = new ServerClientThread(s,counter); //send  the request to a separate thread
        		}catch(IOException ex){}//UserThread newUser = new UserThread(socket, this);
                	//userThreads.add(sct);
                	//BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
                	//newUser.start();
                	//name  = input.readLine();
	 		users.add(name); 
        		//clients.add(c);
        		//c.start();
      		}//while (true) {
			//Socket s = ss.accept();
		}catch(Exception e){}  
       
       }
 
    
    
 
    public void broadcast(String user, String message)  {
	    // send message to all connected users
	    //System.out.println(" in  broad cast ");
	    for ( ServerClientThread c : clients ){
	    	System.out.println(" in  broad cast ");
	       if ( ! c.getUserName().equals(user) )
	          c.sendMessage(user,message);
	    }
    }
    
    
  class ServerClientThread extends Thread {
  String name = "";
  Socket s;
  private int clientNo;
  //private int squre;
  private int option=0;
  //private Server server;
  public BufferedReader r;
  public PrintWriter out;
  
  public ServerClientThread(Socket inSocket,int counter) throws IOException{
    s = inSocket;
    clientNo=counter;
    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter p = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
    this.r=br;
    this.out=p;
    clients.add(this);
    name  = br.readLine();
    users.add(name); // add to vector
    start();
    //server=svr;
  } 
  
  public int getOption(){
  	return this.option;
  }
  public void sendMessage(String uname,String  msg)  {
	    out.println( uname + ":" + msg);
  }
    	         
  public String getUserName() {  
            return name; 
  }	
  public void run(){
  			
  			try{
  			String response="";
			int i=4;
			int index=0;
			double D=0.0;
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
  			do{	
			index=0;
			pw.println("\n\t\t\t1.chat\n\t\t\t2.Graph plot\n\t\t\t3.Convertor\n\t\t\t4.Exit\n");
			pw.println("-EOF-");
			pw.flush();
			response=br.readLine();	
			System.out.println(response);
			//System.out.println("coming till here1");
			try{
				i=Integer.parseInt(response);
				
			}catch(NumberFormatException a){i=4;}
			if(i<=0 ||i>=5) i=4;
			option = i;
			//System.out.println("coming till here2");
			switch(i){
				case 1:
					try{
					//System.out.println("coming till here");
					//Chat chat = new Chat(s,r,out,this);	
					pw.println("chat");
					pw.flush();
					//do{
					chatStart();
					
					}catch(Exception e){System.out.println(e.getMessage());}
				        
				        break;
				case 2: 
				      
				       break;
				case 3:
				       break;
				case 4:index=-4;
				       break;
			}//if(index!=-4 )response=r.readLine();
			}while(index!=-4);
			pw.println("!!!!!!!!!!!!!!!!!!!!!!!!!!THANKYOU FOR USING THESE SERVICES HAVE A GOOD DAY!!!!!!!!!!!!!!!!!!!");
			pw.println("bye");
			pw.flush();

			/*String name = r.readLine();
			out.println("Hello " + name);
			out.flush();*/
			
			s.close();	
  		//}
		}catch(Exception e){System.out.println(e.getMessage());}
  }
 public void chatStart(){
 	     String line;
 	     //try{
 	     //this.name = r.readLine();
	     //}catch(IOException e){}
	     try    {
                while(true)   {
		 line = r.readLine();
		 //System.out.println(" in ChatStart ");
		 if ( line.equals("end") ) {
		    clients.remove(this);
		    users.remove(name);
		   break;
                 }
                 //System.out.println(line);
		 broadcast(name,line); // method  of outer class - send messages to all
	       } // end of while
	     } // try
	     catch(Exception ex) {
	       System.out.println(ex.getMessage());
	     }
 }	 
		
        
}
   
    
}
