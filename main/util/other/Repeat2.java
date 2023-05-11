import java.io.*;
import java.util.*;
public class Repeat{
private static boolean check(String input) {
    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        if (Character.isLetter(ch) && input.indexOf(ch, i + 1) != -1) {
            return true;
        }
    }
    return false;
}
public static void main(String[] args){
		File fp=new File("words-6letter2.txt");
		try{
		List<String> arr = new LinkedList<>();

		BufferedReader br = new BufferedReader(new FileReader(fp)); 
		String st; 
		while ((st = br.readLine()) != null){
		       	if(!check(st))
			arr.add(st);

		}
		FileWriter writer = new FileWriter("words-6letter.txt"); 
		for(String str: arr) {
  		writer.write(str+"\n");
		}
		writer.close();
		/*File fp2=new File("words-4.txt");
		int index=0;
		while(index!=listofwords.length){
			
		}*/
  		}
		catch(IOException a){}
}
}
