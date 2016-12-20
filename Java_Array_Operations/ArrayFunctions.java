/**
 * @author Matthew DeBerry
 * @version 04-22-2014
 * 
 * This class will implement a Java Interface. This class contains all of the methods necessary to 
 * sort, getmax, getmin, search value, sum, reverse, print, and double the array size. These methods use the Java API pre-written array class. 
 */

import java.util.Arrays;

public class ArrayFunctions implements ArrayFunctionsInterface {

	/**
	 * @param array of double
	 * @see ArrayFunctionsInterface#sortMe(double[])
	 * @return array
	 * 
	 * This method will sort the array and return the sorted array.
	 * 
	 */
	
	public double[] sortMe(double[] array) {
		Arrays.sort(array); //call for method sort.
		
		return array; //return sorted array
	}

	/**
	 * @param double array
	 * @return maxValue 
	 * @see ArrayFunctionsInterface#getMax(double[])
	 * 
	 * This method will get the max value of the incoming array and return the maxValue.
	 */
	
	public double getMax(double[] array) {
		double maxValue = -Double.MAX_VALUE;
		
		for(int i = 0; i < array.length; i++) { //For loop cycles array
			if(array[i] > maxValue) { //If element of array is greater than previous maxValue, new max value is set.
				maxValue = array[i]; //sets new max value
			}
		}
		
		return maxValue; //return the max value
	}

	/** 
	 * @param array of double
	 * @return minValue
	 * @see ArrayFunctionsInterface#getMin(double[])
	 * 
	 * This method will sort the array at each element and find the minimum value.
	 * The minimum value will then be returned. 
	 */
	
	public double getMin(double[] array) {
		double minValue = Double.MAX_VALUE;
		
		for(int i = 0; i < array.length; i++) { //for loop compares values less than min value, sets the new min value if true and then returns the min value. 
			if(array[i] < minValue) {
				minValue = array[i];
			}
		}
		
		return minValue;
	}

	/** 
	 * @param double array, double searchValue
	 * @return i
	 * @see ArrayFunctionsInterface#whereAmI(double[], double)
	 */
	
	public int whereAmI(double[] array, double searchValue) {
		for(int i = 0; i < array.length; i++) { //for lopp searchs the lenght of the array
			if(array[i] == searchValue) { //if search value equals the subscript in the array, return that value.
				return i;
			}
		}
			
		return -1;
	}

	/**
	 * @param double array
	 * @return sum
	 * @see ArrayFunctionsInterface#sumMeUp(double[])
	 * This method will sum each element of the array and return the summed value. 
	 */
	
	public double sumMeUp(double[] array) {
		double sum = 0; // initilaize the sum to 0
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i]; // add each value of the array
		}
		
		return sum; //return the sum
	}

	/** @param double array
	 * @return reversed array
	 * @see ArrayFunctionsInterface#reverseMe(double[])
	 * This method will reverse the array values. 
	 */
	
	public double[] reverseMe(double[] array) {
		int index = 0; //initialize to zero
		double[] reversedArray = new double[array.length]; //creat new instance
		
		Arrays.sort(array); //sort array
		
		for(int i = array.length - 1; i > -1; i--) {
			reversedArray[index] = array[i]; //reverses array
			index++;
		}
		
		
		return reversedArray; //return the reversed array
	}

	/** @param double array
	 * @return void
	 * @see ArrayFunctionsInterface#printMe(double[])
	 * This method prints the contents of the array to the console. 
	 */
	
	public void printMe(double[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " "); //print each value of the array
		}
		System.out.println(); //print a blank line
	}

	/**
	 * @param double array
	 * @return bigArray
	 * @see ArrayFunctionsInterface#doubleMySize(double[])
	 * This method will take in the original array and then double the size of the array.
	 * 
	 * 
	 */
	
	public double[] doubleMySize(double[] array) {
		int index = 0;
		double[] bigArray = new double[array.length * 2]; //create new instance of the array and then multipy it by 2 (doubles the array)
		
		while(index < bigArray.length) {
			for(int i = 0; i < array.length; i++) {
				bigArray[index] = array[i];
				index++;
			}
		}
		
		return bigArray;// return doubled array.
	}

}
