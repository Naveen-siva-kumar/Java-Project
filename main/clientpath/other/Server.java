/**
 * naveen
 * main fumction
 */

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
public class Server{

  public static void main(String[] args){
    		int counter=0;
		try{	
		ServerSocket ss = new ServerSocket(9999);
		while(true){
        		counter++;
        		Socket s=ss.accept();  //server accept the client connection request
        		System.out.println(" >> " + "Client No:" + counter + " started!");
        		ServerClientThread sct = new ServerClientThread(s,counter); //send  the request to a separate thread
        		sct.start();
      		}//while (true) {
			//Socket s = ss.accept();
		}catch(Exception e){}
  }
 
}  
