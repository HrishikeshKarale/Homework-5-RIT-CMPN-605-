
public class Receipt
{
	static String receipt[][]= new String[100][3];
	
	/**
	 * this method prints the reciept.
	 * 
	 * @param object
	 */
	public void print(Object object[])
	{
		
		for(int i=0; i<100; i++)
		{
			if( Cashier.conveyer_belt[i] != null)
			{
				receipt[i][0] = Cashier.conveyer_belt[i];
				for(int j=0; j<100; j++)
				{
					if( Cashier.conveyer_belt[i] == Cart.cart[j][0] )
					{
						receipt[i][1] = Cart.cart[j][1];
						for(int k=0; k<100; k++)
						{
							if( Cashier.conveyer_belt[i] == Item.items[k][0] )
								receipt[i][2] = Item.items[k][1] ;
						}
					}
				}
			}
		}
		
		System.out.println("ID\tNAME\t\t\tUNIT\tPRICE/UNIT");
		for (int i=0; i<120; i++)
			if(Item.items[i][0]!=null)
				System.out.println(i+"\t"+Item.items[i][0]+"\t\t\t"+Item.items[i][1]);
	}
}