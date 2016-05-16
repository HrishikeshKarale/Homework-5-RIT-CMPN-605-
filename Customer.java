import java.util.*;
//import java.io.*;

public class Customer
{
	
	static String customer_name;
	
	void setName(String name)
	{
		customer_name=name;
	}
	
	 /**
	  * this method takes in object array as an parameter and  asks the user
	  * or the customer what he wants to buy and what quantity, also the
	  * customer is asked if he would use a bag for the purchase or just add
	  * all the items to the cart
	  * 
	 * @param object
	 * @return object
	 */
	public Object[] selectItems(Object object[])
	{
		int position=0;;
		String bag;
		String ans;
		String item_name;
		String no_of_units;
		String items[][];
		Item item_object = new Item();
		Bag bag_object = new Bag();
		Cart cart_object = new Cart();
		Scanner scr= new Scanner(System.in);
//		BufferedReader scrr = new BufferedReader(new InputStreamReader(System.in));
		object[5] = item_object;
		object[1] = cart_object;
		object[2] = bag_object;
		
		items = item_object.get();
		
		System.out.println("ID\tNAME\t\t\tPRICE/UNIT");
		for (int i=0; i<items.length; i++)
			if(items[i][0]!=null)
				System.out.println(i+"\t"+items[i][0]+"\t\t\t"+items[i][1]);

		do
		{
			System.out.print("Enter ID of item to buy: ");
			position = scr.nextInt();
//			position = Integer.parseInt(scrr.readLine());
			item_name = Item.items[position][0];
			System.out.print("Enter units to the above item to buy: ");
			no_of_units = scr.next();
			System.out.print("DO u want to put this item in a bag?(Y/N) ");
			bag = scr.next();
			
			if(bag.toLowerCase()=="y" || bag.toLowerCase()=="yes")
				bag="true";
			else if (bag.toLowerCase()=="n" || bag.toLowerCase()=="no")
				bag="false";
			
			if(bag=="true")
			{
				bag_object.add(item_name, no_of_units);
				cart_object.add(item_name, no_of_units , bag);
			}
			else
				cart_object.add(item_name, no_of_units, bag);
			
			System.out.print("DO u Want to continue? (Y/N) " );
			ans = scr.next();
			
			if(ans.toLowerCase()=="y" || ans.toLowerCase()=="yes")
				ans="true";
			else if (ans.toLowerCase()=="n" || ans.toLowerCase()=="no")
				ans="false";

		}while (ans=="true");
		scr.close();
		
		return object;
	}
 
}
