
public class Item
{
	static String items[][] = new String[120][2];

	/**
	 * Initializes what items the store has and the prices associated
	 * with the individual items
	 */
	Item()
	{
		items[0][0]="red apple"; items[0][1]= "0.25";
		items[1][0]="green apple"; items[1][1]= "0.28";
		items[2][0]="yellow apple"; items[2][1]= "0.29";
		items[3][0]="milk(L)"; items[3][1]= "2.49";
		items[4][0]="Milk(S)"; items[4][1]= "1.49";
		items[5][0]="Milk(1/2 Pint)"; items[5][1]= "1";
		items[6][0]="pears"; items[6][1]= "0.15";
		items[7][0]="bananas"; items[7][1]= "0.25";
		items[9][0]="flour"; items[9][1]= "0.75";
		items[10][0]="kiwi"; items[10][1]= "0.65";
		items[11][0]="Orange"; items[11][1]= "0.35";
		/*
		items[12][0]=apple; items[12][1]= 0.25;
		items[13][0]=apple; items[13][1]= 0.25;
		items[14][0]=apple; items[14][1]= 0.25;
		items[15][0]=apple; items[15][1]= 0.25;
		items[16][0]=apple; items[16][1]= 0.25;
		items[17][0]=apple; items[17][1]= 0.25;
		items[18][0]=apple; items[18][1]= 0.25;
		items[19][0]=apple; items[19][1]= 0.25;
		items[20][0]=apple; items[20][1]= 0.25;
		items[21][0]=apple; items[21][1]= 0.25;
		items[22][0]=apple; items[22][1]= 0.25;
		items[23][0]=apple; items[23][1]= 0.25;
		items[24][0]=apple; items[24][1]= 0.25;
		items[25][0]=apple; items[25][1]= 0.25;
		items[26][0]=apple; items[26][1]= 0.25;
		items[27][0]=apple; items[27][1]= 0.25;
		items[28][0]=apple; items[28][1]= 0.25;
		items[29][0]=apple; items[29][1]= 0.25;
		*/
	}
	
	/**
	 * This method returns price of the item sent to us as a parameter
	 * 
	 * @param product
	 * @return price of the product
	 */
	Double getPrice(String product)
	{
		for(int i=0; i<120; i++)
			if (items[i][0] == product)
				return Double.parseDouble(items[i][1]);
		return 0.0;
	}

	/**
	 * this method returns the list of items from the store
	 * 
	 * @return items
	 */
	String[][] get()
	{
		return items;
	}
}