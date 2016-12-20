/**
 * 
 * This class will allow the user to  purchase an given the discount percentage and the tax rate. It allows the user to 
 * calculate the price of multiple items if desired.
 * @author Matthew DeBerry
 * @version 1.0
 * @Date 2/24/14
 */

public class SaleItem {
	/* Fields for the SaleItem class that will hold the price of the item,
	 * the discount percent and the tax rate.
	 */
	double priceOfItem;
	double discountPercent;
	double TAX_RATE;
	
	
	/*
	 * Default Constructor that initializes the field values (gives starting values)
	 * 
	 */

	public SaleItem() 
	{ discountPercent = 0.10; TAX_RATE = 0.075; priceOfItem =0;} 
	
	
	/**
	 * Establishes local variables to hold discount percent and the tax rate
	 * @param DiscountPercent
	 * @param TaxRate
	 */
	public SaleItem(double DiscountPercent, double TaxRate) 
	{ discountPercent = DiscountPercent; 
	TAX_RATE = TaxRate; 
	}
	
	
	
	
	/**
	 * @return discount percent
	 */
	public double calcDiscountPrice() 
	{ return priceOfItem - (priceOfItem * discountPercent); 
	}
	
	
	
	
	
	/**
	 * @return final price of the item by calling the required methods to 
	 * complete the calculations
	 */
	public double calcFinalPrice() 
	{ return calcDiscountPrice() + (calcDiscountPrice() * TAX_RATE);
	}
	
	
	
	
	
	/**
	 * set method for the price
	 * @param Price
	 */
	public void setPrice(double Price)
	{ priceOfItem = Price;
	}
	
	
	
	
	/**
	 * Set method for the tax rate
	 * @param TaxRate
	 */
	public void setTaxRate(double TaxRate) 
	{ TAX_RATE = TaxRate; 
	}
	
	
	
	
	/**
	 * Set method for the discount percentage
	 * @param DiscountPercent
	 */
	public void setDiscountPercent(double DiscountPercent) 
	{ discountPercent = DiscountPercent; 
	}
}