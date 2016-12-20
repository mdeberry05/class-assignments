#include <iostream>
using namespace std;

//Reference
//https://en.wikipedia.org/wiki/Fibonacci_number

int fib_gen(int n)
{
    if (n == -1)
	{
		return -1;
	}
	else if (n == 0)
	{
		return 0;
	}
	else if (n == 1)
	{
		return 1;
	}
	else
	{
		return (fib_gen(n - 1) + fib_gen(n - 2));
	}
}

int main()
{

	int n;
	cout << "Enter an integer 'n' and the Fibonnaci sequence will be printed!" << endl;
	cin >> n;
	cout<<endl;

	cout << "The generated sequence is: " << endl;
	for (int i = 1; i < n; ++i)
	{
		cout << fib_gen(i) << "+";
	}
	return 0;
}