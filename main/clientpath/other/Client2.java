/**
 * sairam
 * naveen
 */
//package main;
//import main.util.*;
import java.net.*; 
import java.io.*; 
  
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
		
			Socket s = new Socket("10.0.3.159",9999);
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			String response = r.readLine();
				
			do{
				System.out.println(response+ANSI_WHITE);
				response=r.readLine();
			}while(!response.equals("-EOF-"));
			
			do{	
				//try{
				string=Validator.getString("");
				out.println(string);
				out.flush();
				//response=r.readLine();
				
				do{
				   response=r.readLine();
				   if(!response.equals("-EOF-"))
				   System.out.println(ANSI_WHITE+response+ANSI_GREEN);
				   //System.out.println(response);
				}while(!response.equals("-EOF-") && !response.equals("bye"));
				/*}
				catch(NullPointerException n){
				
					System.out.println("Sorry you have entered something wrong ");
					continue;
				}
				catch(NumberFormatException n){
					System.out.println("Sorry you have entered some number wrong ");
					continue;
				}
				catch(IOException e){
					System.out.println("IOException has occured");
					continue;
				}*/

			
			}while(!response.equals("bye"));
		
			s.close();
		}
		
		catch(UnknownHostException u){
			System.out.println(ANSI_RED + "Sorry there is no host with that ip address and the port " +ANSI_RESET);
		}
		
		catch(IOException e){
			System.out.println(ANSI_RED+"Server is not on"+ANSI_RESET);
		}
		/*catch(ClassNotFoundException e){
			System.out.println("Validator.class file is not their in your file Please include it ");
		}*/
		catch(NullPointerException n){
				
			System.out.println(ANSI_RED+"Sorry you have entered something wrong "+ANSI_RESET);
	//		continue;
		}

		/*out.println("MyName");*/

	}
}
