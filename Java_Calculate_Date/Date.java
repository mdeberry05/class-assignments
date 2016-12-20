/**
 * @author Matthew DeBerry
 * @version 1.0
 * @since April 7, 2014
 * 
 * This class will serve as a date manipulation class. It will add, subtract, convert, compare , and send string representations
 * of hardcoded dates. 
 * 
 * 
 */

public class Date {
    
   //Fields 
    int days; //Variable to hold days value
    int month; // Varibale to hold mont value
    int year; //Variable to hold the year value
    int day; //Varibale to hold the day value
    
    /**
     * This is the default constructor without args. It gives the fields their starting values. 
     * @param none
     * @return none
     */
    public Date() 
    {
        days = 0; //initialize days to 0
        ConvertToDate();
    }
    
    /**
     * This is the constructor with args. It will also calculate the days for the year.
     * @param Month, Day, Year
     * @return none
     */
    public Date(int Month, int Day, int Year) 
    {     
        month = Month; //local variables
        day = Day;
        year = Year;
        
        days = (Month * 30) + Day + (Year * 365); //calculate days for year
    }
    
    /**
     * This is the copy constructor. It will send the days to the ConvertToDate method.
     * @param Date obj
     * @return ConverToDate()
     */
    public Date(Date obj) 
    {
        this.days = obj.days;
        ConvertToDate();
    }
    /**
     * This method Add() will take in the number of days and and to number of
     * days which is then sent to the convertToDate method for connverting.
     * @param numberOfDays
     * @return void
     */
    public void Add(int numberOfDays) 
    {
        days += numberOfDays;
        ConvertToDate();
    }
    /**
     * This method Subtract() will simply subtract the number of days  
     * and then call the convertToDate() method.
     */
    public void Subtract(int numberOfDays) 
    {
        days -= numberOfDays;
        ConvertToDate();
    }
    /**
     * This method will calculate the difference in days and ensure that the result 
     * is always a positive integer.
     * @param Date obj
     * @return difference in days
     */
    public int CalculateDifference(Date obj) 
    {
        return Math.abs(this.days - obj.days); //Make sure the result is always positive
    }
    /**
     * ToString Method- This method will take in the set month, day, and year and 
     * display a textual representation of the code.
     * @param none
     * @return month, day, year
     * 
     */
    public String toString() 
    {
        return month + "/" + day + "/" + year;
    }
    /**
     *  The method below is the equals method and will compare the days to
     *  check for equality. True is retiurned if they are equal, otherwise false is
     *  returned.
     *  @param Date obj
     *  @return days
     */
    public boolean equals(Date obj) 
    {
        return this.days == obj.days;
    }
    /**
     * This method is the compareTo method which contains more information than the equals method can 
     * provide. A positive integer is returned if the statemant is considered larger, ngeative if
     * smaller, and zero if the numbers are equal.
     * @param Date obj
     * @return int
     */
    public int compareTo(Date obj) 
    {
        if(this.days > obj.days) //Return positive integer if comparison is greater
            return 1;
        else if (this.days == obj.days) //Return zero value if the comparison is equal
            return 0;
        else if (this.days < obj.days) //Return negative value if the comparison proves to be smalle
            return -1;
        else
            return -999; //Else return -999 if none of the conditions are true. 
    }
    /**
     * This method ConvertToDate returns no value, is used to coomnvert the sate set within
     * the constructor by breaking it down into days. Leap year is taken into account.
     * @param none
     * @return none
     */
    private void ConvertToDate() 
    {
        year = days / 365; //Year is days divided by 365
        month = (days % 365) / 30; //Convert days into month
        day = (days % 365) % 30;  //Convert days into day variaable
    }
    
    /**
      * This method will convert the days into long format, Month, day, year.
      * @param mont, day, year
      * return String
      */
public String toString(int month, int day, int year) 
{
    if ( month == 1 && day <=31)
        return "January " + day +","+year;
    else if (month == 2 && day <=28)
        return "February " + day +","+year;
    else if (month == 3 && day <=31)
        return "March " + day +","+year;
    else if (month == 4 && day <=30)
        return "April " + day +","+year;
    else if (month == 5 && day <=31)
        return "May " + day +","+year;
    else if (month == 6 && day <=30)
        return "June " + day +","+year;
    else if (month == 7 && day <=31)
        return "July " + day +","+year;
    else if (month == 8 && day <=31)
        return "August " + day +","+year;
    else if (month == 9 && day <=30)
        return "September " + day +","+year;
    else if (month == 10 && day <=31)
        return "October " + day +","+year;
    else if (month == 11 && day <=30)
        return "November " + day +","+year;
    else if (month == 12 && day <=31)
        return "December " + day +","+year;
    else
    return "Something Went Wrong!";
        
    }

}
       
       
       
       
