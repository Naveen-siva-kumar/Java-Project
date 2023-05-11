/**
 * naveen
 * cows and bulls game
 */

package main;
import java.util.*;
//import java.IO.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Random;

public class CBGame{
	public CBGame(){}	
	private final static int size4 = 403; 
	private final static int size5 = 367; 
	private final static int size6 = 245;
	private static int size;
    	public static final String ANSI_RESET = "\u001B[0m";
    	public static final String ANSI_BLACK = "\u001B[30m";
   	public static final String ANSI_RED = "\u001B[31m";
    	public static final String ANSI_GREEN = "\u001B[32m";
    	public static final String ANSI_YELLOW = "\u001B[33m";
    	public static final String ANSI_BLUE = "\u001B[34m";
    	public static final String ANSI_PURPLE = "\u001B[35m";
    	public static final String ANSI_CYAN = "\u001B[36m";
    	public static final String ANSI_WHITE = "\u001B[37m";
	//private static String word;
	
	/*private void setWord(String w){
		this.word=w;
	}*/


	public  int  gameStart(BufferedReader r,PrintWriter out)throws NullPointerException,IOException{
		int i=-1;
		out.println("\n\n\n\t\t\t\tWelcome to COWS AND BULLS game\n");
		//out.println("-EOF-");
		//out.flush();
		do{
		i=0;
		out.println("\t\t\t\t\tlevel1  size=4\n\t\t\t\t\tlevel2  size=5\n\t\t\t\t\tlevel3  size=6\n");
	//	out.println("-EOF-");
	//	out.flush();
		out.println("Choose the level(number) :");
		out.println("-EOF-");
		out.flush();
		try{	
		String s=r.readLine();
		size = Integer.parseInt(s);
		if(size>=0||size>=4)
			size=1;
		i=gameon(size,r,out);
		}catch( NumberFormatException e) {
			size=1;
			i=gameon(size,r,out);
		}
		}while(i==1);
		out.println("\n\t\t\t!!!!!!!!!!!!!!!!!!!!!!THANKYOU FOR PLAYING HOPE YOU ENJOYED!!!!!!!!!!!!!!!!!!!!!!!!\n");
		out.println("Press any key and then enter key");
		out.println("-EOF-");
		//out.println("-EOF-");
		out.flush();
		return 1;
	}

	private  int gameon(int s,BufferedReader r,PrintWriter out) throws NullPointerException,NumberFormatException{
		size = s;
		File fp=null;

		try{
			switch(size){
			
			case 1:
				fp=new File("words-4letter.txt");
				break;
			case 2:
				fp=new File("words-5letter.txt");
				break;
			case 3:
				fp=new File("words-6letter.txt");
				break;
			}
		}
		catch(Exception e){
			out.print("\n");
			out.println("-EOF-");
			out.flush();
		}size+=3;
		try{
		List<String> listofwords = new LinkedList<>();

		BufferedReader br = new BufferedReader(new FileReader(fp)); 
		String st; 
		while ((st = br.readLine()) != null){
		       	
			listofwords.add(st);

		}
		int number=GenerateRandom(size);
		int turns =0;
		
		if(size==4) {turns=7;out.println("\n\t\t\tYou have " +ANSI_RED+ "7"+ ANSI_WHITE + " chances to guess the word\n\n");/*out.println("-EOF-");out.flush();*/}
		if(size==5) {turns=12;out.println("\n\t\t\tYou have " +ANSI_RED+ "12"+ ANSI_WHITE + " chances to guess the word\n\n");/*out.println("-EOF-");out.flush();*/}
		if(size==6) {turns=20;out.println("\n\t\t\tYou have "+ANSI_RED+ "20"+ ANSI_WHITE + " chances to guess the word\n\n");/*out.println("-EOF-");out.flush();*/}
		
		
		String word = listofwords.get(number);
		word=wordChange(word);
		 
	//	out.println("Word is :" + word);
		
		String response=null;
		out.println("\nEnter" +ANSI_RED+ "giveup"+ANSI_WHITE+"to show the word i.e (you loose the game) \n\n ");
		/*out.println("-EOF-");		
		out.flush();*/

		int check=0;
		number=1;
		int chances=0;
		
  
		
		do{
			check=0;
			if(size==4) chances=7-number;
			else if(size==5) chances=12-number;
			else if(size==6) chances=20-number;
			out.println("Enter the guess word of size "+size);
			out.println("-EOF-");
			out.flush();
			//response=Validator.getString(" :");
			response=r.readLine();
			//System.out.println("response");
			if(!checkString(response)){
			//	System.out.println("responseiam checking");
				if(response.length()==size  && !checkSpecialChar(response)){
					check=checkCowsAndBulls(response,size,word,r,out,number);
			//	System.out.println("responseiamincowbullcheck");
				}
				else{
					if(!response.equalsIgnoreCase("giveup") && !response.equalsIgnoreCase("you  won"))
					out.println("\tYou have entered a bigger or smaller word ");
					out.println("\t\t you have  "+chances+" number of chances");/*out.println("-EOF-");
					out.flush();*/
				}
			}
			else{
				out.println("\tYou have entered a word which has repeated letters ");
				out.println("\t\t you have  "+chances+" number of chances");
				/*out.println("-EOF-");
				out.flush();*/
			}
			if(check==1)
				response="you  won";
			number++;
			
		}while(!response.equalsIgnoreCase("giveup") && number <= turns && !response.equalsIgnoreCase("you  won"));
		if(response.equalsIgnoreCase("giveup")){
			out.println("Word is :" + word);
			out.println("DO you want to continue ?(y/n)");
			out.println("-EOF-");
			out.flush();
			response=r.readLine();
			if(response.equals("y"))
				return 1;
			else
				return 0;
		}
		else if(response.equalsIgnoreCase("you  won")){
			out.println("\t\t\tYOU  WON   \n\n");
			out.println("DO you want to continue ?(y/n)");
			out.println("-EOF-");
			out.flush();
			response=r.readLine();
			if(response.equals("y"))
				return 1;
			else
				return 0;
		}
		else if(number >=turns){
			out.println(ANSI_RED + "\t\tYOU HAVE EXHAUSTED NUMBER OF TURNS\n" + ANSI_WHITE);
			out.println("Word is :" + word);
			out.println("DO you want to continue ?(y/n)");
			out.println("-EOF-");
			out.flush();
			response=r.readLine();
			if(response.equals("y"))
				return 1;
			else
				return 0;
		}
		}
		catch(IOException a){}

	return 0;
	}
private  boolean checkString(String input) {
    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        if (Character.isLetter(ch) && input.indexOf(ch, i + 1) != -1) {
            return true;
        }
    }
    return false;
}

private boolean checkSpecialChar(String input){
	int j=9;
	for(int i=0;i<input.length();i++){
	 char ch = input.charAt(i);
	 if ((ch >= 'A' && ch <= 'Z' ) ||(ch >= 'a' && ch <= 'z'))
		j=0;
	else{
		j=1;
		return true;
	}
	}
	if(j==1)return true;
	else return false;
}	
private String wordChange(String word){
	char[] wor = new char[size]; 
  	int j=0;
        // Copy character by character into array 
        for (int i = 4; i < (size + 4); i++) { 
        	
	       	wor[j++] = word.charAt(i); 
        } 
	String s = String.valueOf(wor);
	return s;
}

			       
private int checkCowsAndBulls(String response,int size,String word,BufferedReader r,PrintWriter out,int number){
	//out.println("In checkcowsand bulls Word is :" + word);
	
        //String stringA = Integer.toString(a);
        int length = response.length();
        int countB = 0;int countC = 0;
	char[] res = new char[length]; 
	char[] wor = new char[size]; 

	int chances=0;
	if(size==4) chances=7-number;
	else if(size==5) chances=12-number;
	else if(size==6) chances=20-number;
  
        // Copy character by character into array 
        for (int i = 0; i < length; i++) { 
            res[i] = response.charAt(i); 
        } 
        for (int k = 0; k < size; k++) { 
            wor[k] = word.charAt(k); 
        } 
        //int[] arrayOutA = toArray(response);
        //int[] arrayOutB = toArray(word);

        for (int i = 0; i < length; i++){
              if (res[i] == wor[i])
                    countB += 1;     
        }
	if(countB!=size){
		//out.println("Number of bulls are :" + countB);
		/*out.println("-EOF-");
		out.flush();*/
		countC=0;
        	for(int i=0;i<length; i++)
			for(int j=0; j<length; j++)
				if(res[i]==wor[j])
					countC++;
				
		out.println("Bulls: "+countB+" cows: "+ (countC - countB)+"\t\t you have "+chances+" more chances");
		/*if(!response.equalsIgnoreCase("giveup") || !response.equalsIgnoreCase("you  won"))
		{out.println("-EOF-");
		out.flush();
		}*/
	}
	else{
		//out.println("YOU WON");
		return 1;
	}
	return 0;

}
private int  GenerateRandom(int size) {
      
	Random rand = new Random(); //instance of random class
	
	int upperbound=0;

	if(size==4)
		upperbound = size4;
	else if(size==5)
		upperbound = size5;
	else if(size==6)
		upperbound = size6;
	
	return rand.nextInt(upperbound); 
      
    }

}
