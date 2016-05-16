import java.util.Scanner;

public class Bag
{
	static private int count=0;
	static private String bag[][] = new String[10][2];
	
	/**
	 * This method takes in name of item i.e bag_name as String and no of units
	 * of item as parameters and adds them to the list.
	 * 
	 * @param bag_name
	 * @param unit
	 */
	public void add(String bag_name, String unit)
	{
		Scanner scr= new Scanner(System.in);
		int counter=0;
		String ans;

		for(int i=0; i<count; i++)
		{
			if(bag[i][0] == bag_name)
			{
				System.out.println("Bag containing "+bag_name+" already exists.");
				System.out.print("Do u want to put these in same bag or use");
				System.out.print(" another bag? (Y/N) ");
				ans=scr.next();
				if(ans.toLowerCase()=="y" || ans.toLowerCase()=="yes")
					ans="true";
				else if (ans.toLowerCase()=="n" || ans.toLowerCase()=="no")
					ans="false";
				
				if(ans=="true)")
				{
					unit = ""+( Integer.parseInt(unit) + Integer.parseInt(bag[i][0]) );
					System.out.println(unit+" "+bag_name+" ADDED to bag in bag");
					counter=1;
					break;
				}
				else
					break;
			}
		}
		
		scr.close();
		
		if(counter==0)
		{
			bag[count][0] = bag_name;
			bag[count][1] = unit;
		}	
	}
	
	/**
	 * This method takes in name of item i.e bag_name as String and no of units
	 * of item as parameters and removes them from the list.
	 * 
	 * @param bag_name
	 * @param unit
	 */
	public void remove(String bag_name, String unit)
	{
		int counter=0;
		String ans;
		Scanner scr = new Scanner(System.in);
		
		for(int i=0; i<count; i++)
		{
			if(bag[i][0] == bag_name)
			{
				System.out.println("Bag containing "+bag_name+" already exists.");
				System.out.print("Do u want to remove these from the");
				System.out.print(" same bag or use another bag? (Y/N) ");
				ans=scr.next();
				if(ans.toLowerCase()=="y" || ans.toLowerCase()=="yes")
					ans="true";
				else if (ans.toLowerCase()=="n" || ans.toLowerCase()=="no")
					ans="false";
				
				if(ans=="true)")
				{
					unit = ""+( Integer.parseInt(unit) - Integer.parseInt(bag[i][0]) );
					System.out.println(unit+" "+bag_name+" REMOVED from bag");
					counter=i;
					break;
				}
				else
					break;
			}
		}
		
		scr.close();
		
		if(Integer.parseInt(bag[count][1])<=0)
		{
			for(int i=counter; i<10; i++)
			{
				bag[i][0]=bag[i+1][0];
				bag[i][1]=bag[i+1][1];
			}
			bag[10][0]=null;
			bag[10][1]=null;
		}
	}
	
	
}