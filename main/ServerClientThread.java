import java.net.*; 
import java.util.*;
import java.io.*;
import java.lang.*;//import java.net.*;
//import java.util.*;
import  java.nio.*;
//import  java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
class ServerClientThread extends Thread {
  Socket s;
  int clientNo;
  int squre;
  ServerClientThread(Socket inSocket,int counter){
    s = inSocket;
    clientNo=counter;
  } 
  public void run(){
  			
  			try{
  			String response="";
			int i=4;
			int index=0;
			double D=0.0;
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
  			do{	
			index=0;
			out.println("\n\t\t\t1.COWS AND BULLS GAME\n\t\t\t2.Graph plot\n\t\t\t3.Convertor\n\t\t\t4.Exit\n");
			out.println("-EOF-");
			out.flush();
			response=r.readLine();	
			try{
				i=Integer.parseInt(response);
				
			}catch(NumberFormatException a){i=4;}
			if(i<=0 ||i>=5) i=4;
			switch(i){
				case 1:
					CBGame game = new CBGame();
				        try{
					      index= game.gameStart(r,out);
				        }catch(NullPointerException e){}
				        break;
				case 2: 
				       try{
				       XYSeries2.Graph(r,out);
				       out.println("image");
				       //out.println("-EOF-");
				       out.flush();
				       //BufferedImage image = ImageIO.read(new File("Image.jpeg"));
       					//ImageIO.write(image, "JPEG", s.getOutputStream());
        				//System.out.println("Client: Image sent to server");
					//s=Send.send(s);
					
					BufferedImage image = ImageIO.read(new File("Image.jpeg"));
	 
	 				OutputStream outputStream = s.getOutputStream();
	 				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      					ImageIO.write(image, "jpeg", byteArrayOutputStream);
        
					byte[] size = ByteBuffer.allocate(4).putInt( byteArrayOutputStream.size() ).array();
       					outputStream.write(size);
        				outputStream.write(byteArrayOutputStream.toByteArray());
       					outputStream.flush();

					//s.close();
	 				
				       }catch(Exception e){}
				//	catch(NullPointerException a){}//XYSeries xy = new XYSeries("");
				       break;
				case 3://Convertor c=new Convertor();
				       try{
					       Convertor c=new Convertor();
				               D=c.convertion(r,out);
				       }
				       catch(NullPointerException e){}
				       out.println("Value of your convertion is :" + D );
				       out.println("-EOF-");
				       out.flush();
				       break;
				case 4:index=-4;
				       break;
			}if(index!=-4 )response=r.readLine();
			}while(index!=-4);
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!THANKYOU FOR USING THESE SERVICES HAVE A GOOD DAY!!!!!!!!!!!!!!!!!!!");
			out.println("bye");
			out.flush();

			/*String name = r.readLine();
			out.println("Hello " + name);
			out.flush();*/
			
		//	s.close();	
  		//}
		}catch(Exception e){System.out.println(" exception has occured");}
  }
}
