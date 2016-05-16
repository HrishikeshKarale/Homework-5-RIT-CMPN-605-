import java.util.Scanner;

public class Cashier
{
	static double total=0;
	static String conveyer_belt[] = new String[100];
	
	/**
	 * This method takes object array as a parameter and and sets limit to the
	 * no of items on the conveyer belt and also asks the user to choose to add
	 * or remove the items from his cart
	 * 
	 * @param object
	 * @return object
	 */
	public Object[] counter(Object object[])
	{
		int counter=0;
		String ans = "1";
		String cart_list[][] = new String[120][3];
		Cart c =(Cart) object[1];
		Cashier cashier_object = new Cashier();
		Receipt receipt_object = new Receipt();
		Scanner scr = new Scanner(System.in);
		object[3] = cashier_object;
		object[4] = receipt_object;
		
		System.out.println(" hello, and Welcome to our store.");
		System.out.println("please put ur items on the conveyer belt.");
		
		cart_list=c.get();
		
		for(int i=0; i<120; i++)
			if(cart_list[i][0]!=null)
			{
				conveyer_belt[i]=cart_list[i][0];
				counter++;
				if(counter>100)
				{
					System.out.print("You Cannot put more than 100 Items on the Conveyer Belt.");
					System.out.println("First 100 items will be accepted at this moment");
					System.out.println(" we Regret for your inconveninece");
					break;
				}
			}
		
		System.out.println("this is ur Selected items\nID\tNAME");
		
		for (int i=0; i<conveyer_belt.length; i++)
			if(conveyer_belt[i]!=null)
				System.out.println(i+"\t"+conveyer_belt[i]);
		
/*		While(ans="ALL_SET".toLowerCase())
		{
			System.out.print("Do you want to add or remove items from the list? (ADD/REMOVE/ ALL SET) ");
			ans= scr.next();
			 switch(ans)
			 {
			 	case ADD:
			 		System.out.print("Do you want to add or remove items from the list? (ADD/REMOVE/ ALL SET) ");
					ans= scr.next();
					break;
			 	
			 	case REMOVE:
			 		System.out.print("Do you want to add or remove items from the list? (ADD/REMOVE/ ALL SET) ");
					ans= scr.next();
					break;
			 	
			 	case ALL_SET:break;
			 	
			 	default: break;
			 	
			 	
			 }
		}
*/
		
		total =calculate(object);
		System.out.print("Would you ike to print receipt? (Y/N) ");
		ans=scr.next();
		if(ans.toLowerCase()=="y" || ans.toLowerCase()=="yes")
			receipt_object.print(object);
		else if (ans.toLowerCase()=="n" || ans.toLowerCase()=="no")
			System.out.println("Thank you!");
		
		scr.close();
		
		return object;
	}
	
	/**
	 * This method takes in Object array as parameter and calculates the total
	 * price of the all that the user has bought..
	 *  
	 * @param object
	 * @return calculated_total
	 */
	public double calculate(Object object[])
	{
		int calculate_total=0;
		Item item_object = (Item)object[5];

		for(int i=0; i<100; i++)
			total=item_object.getPrice( conveyer_belt[i]);
		
		return calculate_total;
	}
}
