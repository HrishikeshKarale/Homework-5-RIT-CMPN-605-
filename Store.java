/**
* Store.java
*
* @version   $Id: Store.java,v_1.0 2014/09/29 21:20:00
*
* @author    hhk9433 (Hrishikesh Karale)
* @author    ap8185 (Atir Petkar)
*
* Revisions:
*      Initial revision
*/

import java.util.Scanner;

/*
 * This Program simulates a customer buying items from a store
 */
public class Store
{

	/**
	 * Main method gives calls to various methods
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		String customer_name;
		Customer customer_object = new Customer();
		Cashier cashier_object = new Cashier();
		Object object[] = new Object[6];
		Scanner scr = new Scanner(System.in);
		
		System.out.print("Enter Customer Name: ");
		customer_name=scr.next();
		
		scr.close();
		
		customer_object.setName(customer_name);
		object = customer_object.selectItems(object);
		object[0] = customer_object;
		object = cashier_object.counter(object);
		
	}
}
