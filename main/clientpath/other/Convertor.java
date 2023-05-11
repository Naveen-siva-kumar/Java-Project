/**
 * This is a programme to convert from one unit / metric to another
 * Naveen
 * 12-2-20
 */
import java.net.*; 
import java.util.*;
import java.io.*;
import java.lang.*;
public class Convertor{
	
	public Convertor(){}	
//	private BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
//	private PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
	public double convertion(BufferedReader r,PrintWriter out){
	   int option;
	   double d=0.0;
	   out.println("\t1.Temperature\n\t2.Length\n\t3.Weight\n\t4.exit\n");
	   out.println("\t\t\tPlease enter your convertion  :");
	   out.println("-EOF-");
	   out.flush();
	   String s="";
	   try{
	   s=r.readLine();
	   }catch(IOException i){}
	   try{
	   option=Integer.parseInt(s);
	   }catch(NumberFormatException q){option = 4;}
	   if(option<=0 ||option >=5){option = 4;}
	   switch(option){
	      case 1:
		      d=temperature(r,out);
		      break;
	      case 2:
		     d=length(r,out);
		     break; 
	      case 3:
		     d=weight(r,out);
		     break;
	      case 4:
		     return 0.0;
	
	   }
	return d;
	}
	private double temperature(BufferedReader r,PrintWriter out){
		int option;
		double d=0.0;
		out.println("\t1.celcius\n\t2.farenheit\n\t3.kelvin\n");
	   	out.println("\t\t\tPlease enter your convertion  :");
	   	out.println("-EOF-");
	   	out.flush();
		String s="";
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
	   	switch(option){
	      		case 1:
				d=celcius(r,out);
				break;
	      		case 2:
				d=farenheit(r,out);
				break;
	      		case 3:
				d=kelvin(r,out);
				break;
	      		/*case 4:
				return 0.0;	
			//	break;
		*/}
		return d;

	}
	private double celcius(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the temperature in celcius :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.farenheit\n\t2.kelvin\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		
		switch(option){
	      		case 1:
				d=(d*(9/5)+32);
				break;
	      		case 2:
				d+=273;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double farenheit(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the temperature in celcius :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.Celcius\n\t2.kelvin\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d=(d-32)*(5/9);
				break;
	      		case 2:
				d=(d-32)*(5/9)+273;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double kelvin(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the temperature in celcius :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.Celcius\n\t2.farenheit\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		
		switch(option){
	      		case 1:
				d-=273;
				break;
	      		case 2:
				d-=273;
				d=(d-32)*(5/9);
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double length(BufferedReader r,PrintWriter out){
		int option;
		double d=0.0;
		String s="";
		out.println("\t1.meter\n\t2.mile\n\t3.yard\n\t4.foot\n");
	   	out.println("\t\t\tPlease enter your convertion  :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
	   	switch(option){
	      		case 1:
				d=meter(r,out);
				break;
	      		case 2:
				d=mile(r,out);
				break;
	      		case 3:
				d=yard(r,out);
				break;
	      		case 4:
				d=foot(r,out);	
				break;
	      		/*case 5:
				return 0.0;	
			//	break;*/
		}
		return d;

	}
	private double meter(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the length in meters :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
		s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.mile\n\t2.yard\n\t3.foot\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d=d*0.000621371;
				break;
	      		case 2:
				d*=1.09361;
				break;
	      		case 3:
				d*=3.28084;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double mile(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the length in miles :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.meter\n\t2.yard\n\t3.foot\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d/=0.000621371;
				break;
	      		case 2:
				d*=1760;
				break;
	      		case 3:
				d*=5280;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double yard(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the length in yards :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.meter\n\t2.mile\n\t3.foot\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d*=0.9144;
				break;
	      		case 2:
				d*=0.000568182;
				break;
	      		case 3:
				d*=3;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double foot(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the length in meters :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.meter\n\t2.mile\n\t3.yard\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d*=0.3048;
				break;
	      		case 2:
				d*=0.000189394;
				break;
	      		case 3:
				d*=0.333333;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double weight(BufferedReader r,PrintWriter out){
		int option;
		double d=0.0;
		String s="";
		out.println("\t1.kg\n\t2.pound\n\t3.ounce\n");
	   	out.println("\t\t\tPlease enter your convertion  :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
	   	switch(option){
	      		case 1:
				d=kg(r,out);
				break;
	      		case 2:
				d=pound(r,out);
				break;
	      		case 3:
				d=ounce(r,out);
				break;
	      		/*case 4:
				return 0.0;	
			//	break;*/
		}
		return d;

	}
	private double kg(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the weight in kilograms :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.pounds\n\t2.ounce\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d*=2.20462;
				break;
	      		case 2:
				d*=35.274;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double pound(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the weight in pounds :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.kilograms\n\t2.ounce\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d/=2.20462;
				break;
	      		case 2:
				d*=16;
				break;
			default:
				return 0.0;
		}
		return d;
	}
	private double ounce(BufferedReader r,PrintWriter out){
		int option;
		double d;
		String s="";
		out.println("Please enter the weight in ounces :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	d=Double.parseDouble(s);
	   	}catch(NumberFormatException q){d = 0;}
		out.println("\t1.kilograms\n\t2.pound\n");
	   	out.println("\t\t\tPlease enter to which you want to convert :");
	   	out.println("-EOF-");
	   	out.flush();
	   	try{
	   	s=r.readLine();
	   	}catch(IOException i){}
	   	try{
	   	option=Integer.parseInt(s);
	   	}catch(NumberFormatException q){option = 4;}
	   	if(option<=0 ||option >=5){option = 4;}
		switch(option){
	      		case 1:
				d/=35.274;
				break;
	      		case 2:
				d/=16;
				break;
			default:
				return 0.0;
		}
		return d;
	}

}
