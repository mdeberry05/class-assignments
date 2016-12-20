/**
 * Driver class that contains the main method and calls to the necessary methods from the SaleItem
 * Class
 * 
 * @author Matthew DeBerry
 * @Version 1.0
 * @Date 2/24/14
 *
 */

/** Import(s) */
import java.util.Scanner; //IMPORT THE SCANNER CLASS

public class Driver {
	
		public static void main(String[] args) {
		boolean endLoop = false; // ALLOWS LOOP TO CONTINUE LOOPING UNTIL ENDLOOP = TRUE
		Scanner consoleIn = new Scanner(System.in); // VARIABLE FOR SCANNER CLASS
		
		do
		{
			SaleItem item = new SaleItem(); //REFERENCE VARIABLE FOR SALE ITEM CLASS
			System.out.print("Enter item price: $"); //USER WILL ENTER THE PRICE OF THE ITEM
			item.setPrice(consoleIn.nextDouble()); //CALLS THE SET METHOD IN THE SALE ITEM CLASS AND PULLS INPUT FROM THE KEYBOARD (CONSOLE IN)
			
			System.out.print("Cash Tendered: $"); //PRINT CASH TENDERED AMOUNT
			double cashTendered = consoleIn.nextDouble(); //VARIABLE TO HOLD THE DOUBLE VALUE FROM THE KEYBOARD
			
			System.out.println("\n---- Calculation ----\n"); //LINE USED FOR FOMATTING THE OUTPUT
			System.out.println("\tOriginal Price: $" + item.priceOfItem); //GETS THE PRICE FROM THE SALEITEM CLASS
			System.out.println("\tDiscount Price: $" + item.calcDiscountPrice());// GETS THE CALCULATED DISCOUNTPRICE
			System.out.println("\tFinal Price: $" + item.calcFinalPrice());// GETS THE CALCULATED FINAL PRICE
			System.out.println("\tChange Due: $" + (cashTendered - item.calcFinalPrice()));//TAKES THE CASH TENDERED AND SUBTRACTS THE CALCULATED FINAL PRICE
			
			System.out.print("\nDo you want to change the discount percentage? (Y for Yes | N for No): "); //PROMPT THE USER TO ENTER ANOTHER VALUE
			String response = consoleIn.next(); // VARIBALE TO HOLD Y OR N 
			
			if((response.charAt(0) == 'Y') || (response.charAt(0) == 'y')) //BRAnCH FOR YES CHOICE
			{
				response = null; //SETS RESPONSE TO NULL VALUE
				
				System.out.print("Enter discount percentage: ");
				item.setDiscountPercent(consoleIn.nextDouble() / 100);//ALLOWS THE USER TO CHNAGE THE DISCOUNT PERCENTAGE
				
				System.out.print("Cash Tendered: $"); //ALLOWS USER TO CHNAGE THE CASH TENDERED
				cashTendered = consoleIn.nextDouble();
				
				System.out.println("\n---- Calculation ----\n");// OUTPUTS THE NEW ITEM INFORMATION
				System.out.println("\tOriginal Price: $" + item.priceOfItem);
				System.out.println("\tDiscount Price: $" + item.calcDiscountPrice());
				System.out.println("\tFinal Price: $" + item.calcFinalPrice());
				System.out.println("\tChange Due: $" + (cashTendered - item.calcFinalPrice()));
			}
			
			System.out.print("\nEnter another item? (Y for Yes | N for No): "); // CONNTINUE PROMPT FOR ANOTHER ITEM
			response = consoleIn.next();
			
			if((response.charAt(0) == 'N') || (response.charAt(0) == 'n')) { endLoop = true; } // CHOICE OF NO BREAKS OUT OF THE PROGRAM
		}
		while(endLoop == false); //WHILE ENDLOOP IS FALSE THE PROGRAM CONTINUES LOOPING, UNTIL THE Y OR y CONDITION IS MET
		
		consoleIn.close(); //USED TO CLOSE THE SCANNER METHOD
	}
}