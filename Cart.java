
public class Cart
{
	static String[][] cart= new String[120][3];
	static private int count=0;
	
	/**
	 * this method returns the array of cart.
	 * @return cart
	 */
	public String[][] get()
	{
		return cart;
	}
	
	/**
	 * This method takes in name of item i.e int_name as String, Bad or not and no of units
	 * of item as parameters and adds them to the cart.
	 * 
	 * @param item_name
	 * @param unit
	 * @param bag
	 */
	public void add(String item_name, String unit, String bag)
	{
		int counter=0;
		for(int i=0; i<count; i++)
		{
			if(cart[i][0] == item_name && bag==cart[i][2])
			{
				unit = ""+( Integer.parseInt(unit) + Integer.parseInt(cart[i][0]) );
				System.out.println(unit+" "+item_name+" ADDED to bag in bag");
				counter=1;
			}
			else if(cart[i][0] == item_name && bag!=cart[i][2])
			{
				unit = ""+( Integer.parseInt(unit) + Integer.parseInt(cart[i][0]) );
				System.out.println(unit+" "+item_name+" ADDED to cart");
				counter=1;
			}
		}
		if(counter==0)
		{
			cart[count][0] = item_name;
			cart[count][1] = unit;
			cart[count++][2] = bag;
		}	
	}
	
	/**
	 *  This method takes in name of item i.e int_name as String, Bad or not and no of units
	 * of item as parameters and removes them to the cart.
	 *
	 * @param item_name
	 * @param unit
	 * @param bag
	 */
	public void remove(String item_name, String unit, String bag)
	{
		int counter=0;
		for(int i=0; i<count; i++)
		{
			if(cart[i][0] == item_name && bag==cart[i][2])
			{
				unit = ""+( Integer.parseInt(unit) - Integer.parseInt(cart[i][0]) );
				System.out.println(unit+" "+item_name+" remaining in the bag");
				counter=i;
				break;
			}
			else if(cart[i][0] == item_name && bag!=cart[i][2])
			{
				unit = ""+( Integer.parseInt(unit) - Integer.parseInt(cart[i][0]) );
				System.out.println(unit+" "+item_name+" ADDED to cart");
				counter=i;
				break;
			}
		}
		if(Integer.parseInt(cart[count][1])<=0)
		{
			for(int i=counter; i<149; i++)
			{
				cart[i][0]=cart[i+1][0];
				cart[i][1]=cart[i+1][1];
				cart[i][2]=cart[i+1][2];
			}
			cart[149][0]=null;
			cart[149][1]=null;
			cart[149][2]=null;
		}
	}
	
}
