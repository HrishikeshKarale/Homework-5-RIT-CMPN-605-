/**
* Store.java
*
* @version   $Id: Store.java,v_1.0 2014/09/29 04:20:00
*
* @author    hhk9433 (Hrishikesh Karale)
* 
* Revisions:
*      Initial revision
*/

import java.util.*;
import java.io.*;

/*
 * This Program selects an object from given objects such that the sum of the
 * distance of our center object from allother objects is minimum
 */

public class Center
{
	/**
	 * this method reads the line as parameter and then converts them into points
	 * 
	 * @param line
	 * @return xyz coordinates
	 */
	private int[] coordinates(String line)
	{
		//stores x,y,z co-ordinate found on line
		int xyz_value[] = new int[3];
		//stores values of line.split()
		String str_xyz_value[] = new String [3];
		str_xyz_value=line.split("\\s");
		
//		System.out.println(str_xyz_value[0]+" "+str_xyz_value[1]+" "+str_xyz_value[2]);
		
		for(int i=0; i<3; i++)
			xyz_value[i]=Integer.parseInt(str_xyz_value[i]);

		return xyz_value;
	}
	
	/**
	 * this method takes in the current point and one other point to calculate
	 * the distance between the two points using the pythagorean theorem.
	 * 
	 * @param current_point
	 * @param other_point
	 * @param counter
	 * @return distance
	 */
	private double distance(int current_point[], int other_point[], int counter)
	{
		//to store total distance from current_point[] to points in xyz_value[][]
		double distance=0;
		// to store value for (x2)^2-(x1)^2, (y2)^2-(y1)^2 and  (z2)^2-(z1)^2
		double temp[] = new double[3];

		/*
		 * calculates the distance of the current_point from the other_point
		 * using the distance formula derived from the pythagoras theorem
		 */
		for(int j=0; j<3; j++)
		{
			temp[j] = Math.pow(other_point[j],2) - Math.pow(current_point[j],2);
		}
		distance+=Math.sqrt(Math.abs(temp[0]+temp[1]+temp[2]));
		
		return distance;
	}
	
	/**
	 * this method takes in co-ordinates of all objects and counter and gives 
	 * us the location of ideal point by calculating median of x, y and z and
	 * then naming that point as the ideal point
	 * 
	 * @param xyz_values
	 * @param counter
	 * @return ideal point
	 */
	private int[] findIdealPoint( int xyz_values[][], int counter)
	{
		//to store ideal point from xyz_values
		int ideal_point[] = new int[3];
		int temp[]=new int[counter];
		//calculate ideal x
		for( int i=0; i<3; i++)
		{
			for( int j=0; j<counter; j++)
			{
				temp[j]=xyz_values[j][i];
			}
			Arrays.sort(temp);
			if( temp.length%2 != 0 )
				ideal_point[i] = temp[temp.length/2];
			else
				ideal_point[i]=(temp[(temp.length/2)-1]+temp[(temp.length/2)])/2;
		}	
		return ideal_point;
	}
	
	/**
	 * this method takes in co-ordinates of objects, ideal point and counter as
	 * input parameters and give us prospective point positions by choosing five
	 * closest to the ideal point. 
	 * 
	 * @param xyz_values
	 * @param ideal_point
	 * @param counter
	 * @return prospective points
	 */
	private int[][] prospectivePoints(int xyz_values[][], int ideal_point[], int counter)
	{
		//to store min distance for comparison
		double min=1000;
		//to store previous min distance
		double new_min=1;
		//to store distance returned from distance() call
		double distance=-1;
		Center center_object = new Center();
		//to store set of points which are closest to the ideal_point 
		int prospective_points[][] = new int[5][3];	
		
		System.out.println();
		
//		System.out.println(ideal_point[0]+"  "+ideal_point[1]+"  "+ideal_point[2]+"  ");		
		
		for (int i=0; i<5; i++)
		{
			for (int j=0; j<counter; j++)
			{
				distance = center_object.distance(ideal_point, xyz_values[j], counter);
				if(distance<min && new_min<distance)
				{
					min=distance;
					prospective_points[i]=xyz_values[j];
				}
			}
			new_min=min;
			min=1000;
			prospective_points[i]=prospective_points[i];
		}

		return prospective_points;
	}
	
	/**
	 * this method calculates the diatance of our prospective points from all
	 * other points and selects the point with min sum of distance as our
	 * final point
	 * 
	 * @param xyz_values
	 * @param counter
	 * @return point
	 */
	private int[] calculate(int xyz_values[][], int counter)
	{
		//to store min distance for comparison
		double min=1000;
		//to store distance returned from distance() call
		double distance=0;
		//to store point which is being currents considered as center object
		int point[] = new int[3];
		//to store point which should ideally be center object of all objects
		int ideal_point[] = new int[3];
		//to store set of points which are closest to the ideal_point 
		int prospective_points[][] = new int[5][3];
		Center center_object = new Center();
		//to store sum of distance of prospective points from all other points
		double dist[]= new double[5];
		
		ideal_point = center_object.findIdealPoint( xyz_values, counter);
		prospective_points = center_object.prospectivePoints( xyz_values, ideal_point, counter);
	
		System.out.println();
		
		for(int i=0; i<5; i++)
		{
			dist[i]=0;
			for(int j=0; j<counter; j++)
			{
				distance = center_object.distance(prospective_points[i], xyz_values[j], counter);
				dist[i]+=distance;
			}
//			System.out.println(prospective_points[i][0]+" "+prospective_points[i][1]+" "+prospective_points[i][2]+"-----"+dist[i]);
		}
		
		
		System.out.println();
		
		
		for(int i=0; i<5; i++)
			if(dist[i]<min)
			{
				min=dist[i];
				point=prospective_points[i];
			}
		return point;
	}
	
	/**
	 * Main method where method calls and final output is printed
	 * 
	 * @param args
	 */
	public static void main( String args[])
	{
		
		//to determine which row the new co-ordinates are to be inserted
		int counter=0;
		// to store the co-ordinates of our center object
		int point[] = new int [3];
		//to Store the co-ordinates returned from coordinate()
		int xyz_values[][] = new int [100][3];
		//to store the current line from the imput.txt file being read
		String line = null;
		Center center_object = new Center();
		Scanner scr;
		double dist=0;
		
		try
		{
			scr=new Scanner( new File( "imput.txt"));
			
			while( scr.hasNext())
			 {
				 line=scr.nextLine();
				 xyz_values[counter] = center_object.coordinates(line);
				 counter++;
			 }
			scr.close();
		
			point = center_object.calculate( xyz_values, counter);  
			
			System.out.print("The Center Object co-ordinates are: ");
			System.out.println(point[0]+" "+point[1]+" "+point[2]+"\n");
			System.out.println("The  Distances from our center object from other objects are as follows: ");

			for (int j=0;j<counter;j++)
			{
				dist=center_object.distance(point, xyz_values[j], counter);
				System.out.println(xyz_values[j][0]+" "+xyz_values[j][1]+" "+xyz_values[j][2]+"-------"+(float)dist);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("imput.txt file is no where to be found");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("There is an Error in reading the file");
		}
	}
}
