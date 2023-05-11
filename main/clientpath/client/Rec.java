//package main.client;
//import main.client.*;
import java.io.*;
import java.net.*;
import java.util.*;
import  java.nio.*;
import  java.awt.image.*;

import javax.swing.*;
import  javax.imageio.*;

public class Rec 
{
	public static Socket rec(Socket s)throws Exception 
	{
	//ServerSocket ss = new ServerSocket(5171);
		//while (true) 
		//{
		//Socket s = ss.accept();
		
		InputStream inputStream = s.getInputStream();
		
		byte[] sizeAr = new byte[4];
        	inputStream.read(sizeAr);
			int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

		byte[] imageAr = new byte[size];
		inputStream.read(imageAr);

		BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

		ImageIO.write(image, "jpeg", new File("gottheimage.jpeg"));
		
		//s.close();
		//}
		return s;
	}
}
