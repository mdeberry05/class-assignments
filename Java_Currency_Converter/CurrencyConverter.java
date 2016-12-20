/**
 * This class is called the CurrencyConverter Class and will take the user specified currency scale and do
 * the necessary conversions and return those values in the specified currency scale.  
 * 
 * @author Matthew DeBerry
 * @version 1/30/2014
 * 
 */

public class CurrencyConverter
{
    // Fields for the CurrencyConverter class that will hold the required values once converted.
    private double Dollars;
    private double Euro;
    private double Yen;
    private double Pounds;
    
    // Constant conversion factors.
    private static final double DOLLAR_TO_EURO = 0.7311; 
    private static final double DOLLAR_TO_POUNDS = 0.6064;
    private static final double DOLLAR_TO_YEN = 102.32;
    

    //Constructor takes in monetary amount and desired currency scale
    // this constructor expects two values monetaryValue and the user specified currency scale.
    
    public CurrencyConverter() {} 							//Blank Constructor Method - See Driver class for note when used.
    public CurrencyConverter(double monetaryValue, char currency)
    {
    	if(currency == 'D' || currency == 'd')
    		Dollars = monetaryValue; 						// Set dollars
    	else if(currency == 'E' || currency == 'e')
            Euro = monetaryValue;							// Set Euros
        else if (currency == 'Y' || currency == 'y')
            Yen = monetaryValue;							// Set Yen
        else if (currency == 'P' || currency == 'p')
            Pounds = monetaryValue;							// Set British Pounds
    }
    
/** This method allows the user to change the currency
 * to new values. This is a mutator method (setter method
 * It allows the outside world to change the values of the
 * fields, but it maintains the consistency of the two fields.
 * @param monetaryValue - holds value to set the fields
 * @param currency - holds currency character
*/   
   
   public void setCurrency(double monetaryValue, char currency) //Expects these two parameters
    {
    	if(currency == 'D' || currency == 'd')
    		Dollars = monetaryValue;						// Set dollars
    	else if(currency == 'E' || currency == 'e')
    		Euro = monetaryValue;							// Set Euros
    	else if (currency == 'Y' || currency == 'y')
    		Yen = monetaryValue;							// Set Yen
    	else if (currency == 'P' || currency == 'p')
    		Pounds = monetaryValue;							// Set British Pounds
    }
    
    /** For this accessor (getter) method, the user of this class will send in a 
     * letter to indicate what currency type they want returned. This method will convert from the specified currency and convert to
     * the desired currency.
     * @param convertFrom - holds convert from character
     * @param convertTo - holds convert to character
     * @return dollar value in specified scale
     *		and -1 for error checking
     * 
     * 
     */
     
    
    public double getCurrency(char convertFrom, char convertTo) // Convertfrom & Convertto parameter
    {
    	double monetaryValue; //declare local variable 
    	
    	if(convertFrom == 'D' || convertFrom == 'd')	// Conversion branch for Dollars
    	{
    		monetaryValue = Dollars;
    		
    		if(convertTo == 'D' || convertTo == 'd')
        		return monetaryValue;
        	else if(convertTo == 'E' || convertTo == 'e')
        		return monetaryValue * DOLLAR_TO_EURO;		// Return Dollar * Required Conversion Constant
            else if(convertTo == 'Y' || convertTo == 'y')
            	return monetaryValue * DOLLAR_TO_YEN;		// Return Dollar * Required Conversion Constant
            else if(convertTo == 'P' || convertTo == 'p')
            	return monetaryValue * DOLLAR_TO_POUNDS;	// Return Dollar * Required Conversion Constant
    	}
    	else if(convertFrom == 'E' || convertFrom == 'e')	// Conversion branch for Euros
        {
    		monetaryValue = Euro;
    		double dollarValue = monetaryValue / DOLLAR_TO_EURO;	 // Establish dollarValue
    		
    		if(convertTo == 'E' || convertTo == 'e')
    			return monetaryValue;
    		else if(convertTo == 'D' || convertTo == 'd')
    			return dollarValue;
    		else if(convertTo == 'Y' || convertTo == 'y')
    			return dollarValue * DOLLAR_TO_YEN;			// Return Dollar * Required Conversion Constant
    		else if(convertTo == 'P' || convertTo == 'p')
    			return dollarValue * DOLLAR_TO_POUNDS;		// Return Dollar * Required Conversion Constant
        }
        else if(convertFrom == 'Y' || convertFrom == 'y')	// Conversion branch for Yen
        {
        	monetaryValue = Yen;
        	double dollarValue = monetaryValue / DOLLAR_TO_YEN; // Establish dollarValue
    		
    		if(convertTo == 'Y' || convertTo == 'Y')
    			return monetaryValue;
    		else if(convertTo == 'D' || convertTo == 'd')
    			return dollarValue;
    		else if(convertTo == 'E' || convertTo == 'e')
    			return dollarValue * DOLLAR_TO_EURO;		// Return Dollar * Required Conversion Constant
    		else if(convertTo == 'P' || convertTo == 'p')
    			return dollarValue * DOLLAR_TO_POUNDS;   	// Return Dollar * Required Conversion Constant
        }
        else if(convertFrom == 'P' || convertFrom == 'p') 	// Conversion branch for British Pounds Conversion
        {
        	monetaryValue = Pounds;
        	double dollarValue = monetaryValue / DOLLAR_TO_POUNDS; // Establish dollarValue
    		
    		if(convertTo == 'P' || convertTo == 'p')
    			return monetaryValue;
    		else if(convertTo == 'D' || convertTo == 'd')
    			return dollarValue;							// // Return Dollar Value
    		else if(convertTo == 'Y' || convertTo == 'y')
    			return dollarValue * DOLLAR_TO_YEN;			// Return Dollar * Required Conversion Constant
    		else if(convertTo == 'E' || convertTo == 'e')
    			return dollarValue * DOLLAR_TO_EURO;		// Return Dollar * Required Conversion Constant
        }
		return -1; //used to error check if this value is returned
    }
}