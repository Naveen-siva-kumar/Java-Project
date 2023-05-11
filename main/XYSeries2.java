// package main;
// package org.jfree.chart.demo;
 import org.*; 
 import org.jfree.chart.*;
 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.data.xy.XYSeries;
 import org.jfree.data.xy.XYSeriesCollection;
 import org.jfree.ui.ApplicationFrame;
 import org.jfree.ui.RefineryUtilities;
 import java.util.Scanner;
 import java.net.*; 
 import java.util.*;
 import java.io.*;
 import java.lang.*;
 import javax.swing.*;
 import java.awt.*;
// import org.jfree.chart.JFreeChart;
//import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
//import java.io.File;
//import java.io.IOException;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class XYSeries2 {

    public static void Graph(BufferedReader r,PrintWriter out)   throws IOException {

        var series = new XYSeries("");
	int i=0;
	double x=0;double y=0;
	String s="";
	out.println("How many points do you want to plot ?");
        out.println("-EOF-");
        out.flush();
        try{
	s=r.readLine();
	}catch(IOException q){}
        try{
	 i=Integer.parseInt(s);
        }catch(NumberFormatException a){i=2;}
        for(int j=0;j<i;j++){
	 out.println("Enter x coordinate :");
         out.println("-EOF-");
         out.flush();
	 try{
	 s=r.readLine();
	 }catch(IOException q){}
	 try{
	x=Double.parseDouble(s);
	}catch(NumberFormatException a){x=0.0;}
	out.println("Enter y coordinate :");
        out.println("-EOF-");
        out.flush();
	try{
	s=r.readLine();
	}catch(IOException q){}
	try{
	y=Double.parseDouble(s);
	//data.addValue(x,"",s);
	}catch(NumberFormatException a){y=0.0;}
//	y=getDouble("Enter y coordinate :");
	series.add(x,y);
        }
         /*series1.add(18, 530);
        series1.add(20, 580);
        series1.add(25, 740);
        series1.add(30, 901);
        series1.add(40, 1300);
        series1.add(50, 2219);
*/
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Your Data",
                "X - Axis",
                "Y - Axis",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartUtilities.saveChartAsJPEG(new File("Image.jpeg"), chart, 450, 400);
    }
}

       
