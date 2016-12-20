#include <iostream>
using namespace std;


int main()
{
int grade;
cout<<"Please enter your score:"<<endl;
cin>>grade;

	if (grade >= 90)
		{	
			cout<<"Your grade is an A";
		}
	else if (grade >= 80)
		{
			cout<<"Your grade is a B";	
		}
	else if (grade >= 70)
		{
			cout<<"Your grade is a C";
		}
	else if (grade >= 60)
		{
			cout<<"Your grade is an D";
		}
	else
		{
			cout<<"Your grade is an F";
		}

}