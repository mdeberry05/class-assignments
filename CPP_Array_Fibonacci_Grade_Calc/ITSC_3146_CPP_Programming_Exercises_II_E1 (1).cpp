#include <iostream>
using namespace std;

int main()
{
	//variable declarations

	int arrayOfInt[10];
	int count = 10; //used to keep track of number submission
	char response; //user response
	double sum = 0;
	int positive = 0; //used for number of positive integers
	int negative = 0; //used for number of negative integers
	double average = 0.0; //initilize average with a value
	int i;
	int zeros = 0;

	cout << "Please Enter Ten Integers:" << endl;
	for (i = 0; i < 10; i++)
	{
		cin >> arrayOfInt[i];
	}

	for (i = 0; i < 10; i++)
	{
		if (arrayOfInt[i] > 0)
		{
			positive++;
		}
		if (arrayOfInt[i] < 0)
		{
			negative++;
		}
		if (arrayOfInt[i] == 0)
		{
			zeros++;
		}
	}

	//Calculates the sum and average of the numbers

	for (int i = 0; i < 10; i++)
	{
		sum += arrayOfInt[i];
	}

	average = (sum / i);

	cout << "\nThe average of all integers is: " << average << endl;
	cout << "\nThe sum of all numbers is: " << sum << endl;
	cout << "\nThere were " << positive << " postive integers entered" << endl;
	cout << "\nThere were " << negative << " negative integers entered" << endl << endl;
	cout << "The number 0 was entered " << zeros << " times" << endl << endl;

	cout << "\nThe array reversed is: ";
	for (int i = 9; i >= 0; i--)
	{
		cout << "\n" << arrayOfInt[i];
	}

	return 0;
}