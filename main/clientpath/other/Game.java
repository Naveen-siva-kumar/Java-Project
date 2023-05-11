/**
 * naveen
 * main fumction
 */

import java.net.*; 
import java.util.*;
import java.io.*;
import java.lang.*;
public class Game{

  public static void main(String[] args){
    		String response="";
		int i=4;
		int index=0;
		double D=0.0;
		try{	
		ServerSocket ss = new ServerSocket(9999);
		while (true) {
			Socket s = ss.accept();
		
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
				case 1:CBGame game = new CBGame();
				       try{
					      index= game.gameStart(r,out);
				       }catch(NullPointerException e){}
				       break;
				case 2:
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
			}if(i!=4)response=r.readLine();
			}while(index!=-4);
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!THANKYOU FOR USING THESE SERVICES HAVE A GOOD DAY!!!!!!!!!!!!!!!!!!!");
			out.println("bye");
			out.flush();

			/*String name = r.readLine();
			out.println("Hello " + name);
			out.flush();*/
			
		//	s.close();	
  		}
		}catch(IOException e){System.out.println("IO exception has occured");}
  }
}  
