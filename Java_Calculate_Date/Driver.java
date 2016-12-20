

/**
 * This class is called the Driver. It will call and display the results called from
 * the custom Date class.
 * 
 * @author (Matthew DeBerry) 
 * @version (1.0 4/6/2014)
 */
public class Driver {
	public static void main(String[] args) {
		/// Initializing a date to April 7th, 2013
		Date myDate = new Date(4, 7, 2013);
		
		/// Initializing a date to April 8th, 2014
		Date dueDate = new Date(4, 8, 2014);
		
		/// Calculate difference between dates
		System.out.println("The difference between dates " + myDate.toString() + " and "
										+ dueDate.toString()  + " is " + myDate.CalculateDifference(dueDate) +" days.\n");
		
		/// Are the days equal?
		System.out.println("Are dates " + myDate.toString() + " and "
										+ dueDate.toString()  + " equal?: " + myDate.equals(dueDate) +"\n");
		
		/// Adding 366 days to  set date to due date for test
		myDate.Add(366);
		
		/// Are the days equal?
		System.out.println("Are dates " + myDate.toString() + " and "
										+ dueDate.toString()  + " equal?: " + myDate.equals(dueDate) +"\n");
		
	
		/// Set myDate to dueDate using the copy constructor
		myDate = new Date(dueDate);
		System.out.println("The date used for comparison, addition, and subraction is: " + myDate.toString() + ".\n");
		
			if(myDate.compareTo(dueDate) == 0) {
			myDate.Subtract(180);
			
			if(myDate.compareTo(dueDate) != 0) {
				System.out.println("The new date after subtracting 180 days is " + myDate.toString() + "\n");
			}
		}
		
										
		/// Set myDate to be displayed in the long format. 
		myDate = new Date(dueDate);
		System.out.println("The new date in long format is: " + myDate.toString(10,13,2013) + ".\n");
	}
}