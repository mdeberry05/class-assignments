
/**
 * This class was written to test the CurrencyConverter
 * class. The user inputs a USD amount and a scale (either
 * E - Euro, Y - Yen, P- Pounds) THe CurrencyConverter stores the 
 * amount in all scales and this class prints the currency amount in all
 * scales.
 * @author Matthew DeBerry 
 * @version 1/30/2014
 */

public class Driver
{
	public static void main(String[] args)
	{
	    //create a reference variable, this is not a field because it is declared inside of a method
 	    CurrencyConverter converter = new CurrencyConverter(10, 'D');
 	 
 	    /*
 	     * If the empty constructor is utilized, use these instructions below
 	     * to initialize the converter with $10 to be converted.
 	    
 	    converter = new CurrencyConverter();
 	    converter.setCurrency(10, 'D');
 	    
 	    */
 	    System.out.println("10 Dollars to");
 	    System.out.println("\tEuros: " + converter.getCurrency('D', 'E'));
	    System.out.println("\tYen: " + converter.getCurrency('D', 'Y'));
	    System.out.println("\tPounds: " + converter.getCurrency('D', 'P'));
	    
	    
	    /*
	     * The mutator method 'setCurrency(monetaryValue, currency)' is now used
	     * to modify the original currency input. The examples used are 50 Euros,
	     * 100 British Pounds, and 10,000 Japanese Yen. The results are then ouput to the 
	     * screen.
	     */
	    converter.setCurrency(50, 'E');
	    System.out.println("\n50 Euros to");
	    System.out.println("\tDollars: " + converter.getCurrency('E', 'D'));
	    System.out.println("\tYen: " + converter.getCurrency('E', 'Y'));
	    System.out.println("\tPounds: " + converter.getCurrency('E', 'P'));
	    
	    converter.setCurrency(100, 'P');
	    System.out.println("\n100 Pounds to");
	    System.out.println("\tDollars: " + converter.getCurrency('P', 'D'));
	    System.out.println("\tEuros: " + converter.getCurrency('P', 'E'));
	    System.out.println("\tYen: " + converter.getCurrency('P', 'Y'));
	    
	    converter.setCurrency(10000, 'Y');
	    System.out.println("\n10,000 Yen to");
	    System.out.println("\tDollars: " + converter.getCurrency('Y', 'D'));
	    System.out.println("\tEuros: " + converter.getCurrency('Y', 'E'));
	    System.out.println("\tPounds: " + converter.getCurrency('Y', 'P'));
	}
}