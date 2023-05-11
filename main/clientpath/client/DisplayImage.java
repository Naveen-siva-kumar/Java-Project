//package main.client;
//import main.client.*;
import java.io.*;
import java.awt.image.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.WindowConstants.*;
import javax.imageio.*;

public class DisplayImage
{
 public static void display()throws Exception	
 {
	String imagePath = "gottheimage.jpeg";
	
	BufferedImage myPicture = ImageIO.read(new File(imagePath));
	Graphics2D g = (Graphics2D) myPicture.getGraphics();
	
	//g.setStroke(new BasicStroke(3));
	//g.setColor(Color.BLUE);
	
	g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);
	
	JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	JPanel jPanel = new JPanel();
	
	jPanel.add(picLabel);
	
	JFrame f = new JFrame();
	
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()+40));
	f.add(jPanel);
	//f.setResizable(false);
	f.setVisible(true);
	//myPicture.close();
  }
}
