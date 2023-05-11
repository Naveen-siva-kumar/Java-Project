/**
 * sairam
 * naveen
 */
//package main;
//import main.util.*;
//package main.client;
//import main.client.*;
import java.net.*; 
import javax.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*; 
//import java.net.*;
import java.util.*;
import  java.nio.*;
//import  java.awt.image.*;
  
public class Client2{
    	public static final String ANSI_RESET = "\u001B[0m";
    	public static final String ANSI_BLACK = "\u001B[30m";
   	public static final String ANSI_RED = "\u001B[31m";
    	public static final String ANSI_GREEN = "\u001B[32m";public static final String GREEN_B = "\033[0;92m";
    	public static final String ANSI_YELLOW = "\u001B[33m";
    	public static final String ANSI_BLUE = "\u001B[34m";
    	public static final String ANSI_PURPLE = "\u001B[35m";
    	public static final String ANSI_CYAN = "\u001B[36m";
    	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void main(String[] args){
		
		String string="";
		
		try{
		
			//int flag = 0;
			Socket s = new Socket("10.0.3.159",9999);
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			String response ="";//= r.readLine();
				
			do{	
				try{		
				do{
				   response=r.readLine();
				   if(!response.equals("-EOF-"))
				   System.out.println(ANSI_WHITE+response+ANSI_GREEN);
				   //System.out.println(response);
				}while(!response.equals("-EOF-") && !response.equals("bye") && !response.equals("image"));
				if(response.equals("bye"))
					break;//flag = 1;//s.close();
				//if(flag==1)break;
				if(response.equals("image")){
					 //BufferedImage image = ImageIO.read(s.getInputStream());
					try{
						//s=Rec.rec.(s);
						InputStream inputStream = s.getInputStream();
		
						byte[] sizeAr = new byte[4];
        					inputStream.read(sizeAr);
						int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

						byte[] imageAr = new byte[size];
						inputStream.read(imageAr);

						BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

						ImageIO.write(image, "jpeg", new File("gottheimage.jpeg"));
						//ImageIO.close();
						//image.close();
						DisplayImage.display();
					}catch(Exception e ){}
					
					out.println("gottheimage");
					out.flush();
					/*do{
				   		response=r.readLine();
				   		if(!response.equals("-EOF-"))
				   		System.out.println(ANSI_WHITE+response+ANSI_GREEN);
				   		//System.out.println(response);
					}while(!response.equals("-EOF-") && !response.equals("bye") && !response.equals("image"));
					if(response.equals("bye"))
					break;//s.close();*/
				}
			
				else{	
					string=Validator.getString("");
					out.println(string);
					out.flush();
				}
			
				}
				catch(NullPointerException n){
				
					//System.out.println("Sorry you have entered something wrong ");
					continue;
				}
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
		/*catch(ClassNotFoundException e){
			System.out.println("Validator.class file is not their in your file Please include it ");
		}
		catch(NullPointerException n){
				
			System.out.println(ANSI_RED+"Sorry you have entered something wrong "+ANSI_RESET);
	//		continue;
		}*/

		/*out.println("MyName");*/

	}
}
