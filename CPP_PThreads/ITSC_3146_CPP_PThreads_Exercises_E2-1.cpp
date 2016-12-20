#include <iostream>
#include <pthread.h>
using namespace std;



void *printPositve(void *args)
{
    int positive=0;
    int negative=0;
    int zero = 0;
    int *my_array_copy = (int*)args;
         

   
    for (int i=0;i<10;i++)
    {
        
		if(my_array_copy[i]>0)
		{
     		positive++;
		}
	
    }
    
   
   cout << "The number of postive numbers entered are: " << positive<<endl;
   return 0;
}






void *printNegative(void *args)
{
    int positive=0;
    int negative=0;
    int zero = 0;
    int *my_array_copy = (int*)args;

   
    for (int i=0;i<10;i++)
    {
   
		if(my_array_copy[i]<0)
		{
     		negative++;
		}
		else if(my_array_copy[i]==0)
		{
			zero++;
		}
		else
		{
			positive++;
		}
		
		
    }
   

   cout << "\nThe number of negative numbers entered are: " << negative<<endl;
   return 0;
}





void *printZero(void *args)
{
    int positive=0;
    int negative=0;
    int zero = 0;
    int *my_array_copy = (int*)args;

   
    for (int i=0;i<10;i++)
    {
        
		if(my_array_copy[i]<0)
		{
     		negative++;
		}
		else if(my_array_copy[i]==0)
		{
			zero++;
		}
		else
		{
			positive++;
		}
		
    }
   

   cout << "\nThe number of zero numbers entered are: " << zero<<endl;
   return 0;
}



void *printSum(void *args)
{
        
    int sum=0;
    int *my_array_copy = (int*)args;

   
    for (int i=0;i<10;i++)
    {
        
	 sum+=my_array_copy[i];
		
    }
   

   cout << "\nThe sum of all numbers entered are: " << sum<<endl;
   return 0;
}



void *reverseArray(void *args)
{
    int j;
    int temp=0;
    int k=10;
    int *my_array_copy = (int*)args;
    
     
    for(int i=0,j=k-1;i<k/2;i++,j--)
	{
		temp=my_array_copy[i];
		my_array_copy[i]=my_array_copy[j];
		my_array_copy[j]=temp;
	}
	
	
	cout << "\nThe reverse order of numbers: ";
	
	
	for(int i=0;i<k;i++)
	{
	    cout<<my_array_copy[i]<<" ";
	}
	
   cout << "\n";
   
   return 0;
}


void *printAverage(void *args)
{
        
    int sum=0;
    double average=0;
    int *my_array_copy = (int*)args;

   
    for (int i=0;i<10;i++)
    {
        
	 sum+=my_array_copy[i];
	 
    }
    
   average=sum/10;

   cout << "\nThe average of all numbers entered are: " << average<<endl;
   return 0;
}






int main()
{
    int my_array[10];
    pthread_t id,id1,id2,id3,id4,id5;
    int rc;
    
    
   
    for (int i=0;i<10;i++)
    {
        
    cout<<"\nEnter Number ";
    cin>>my_array[i];
    
    }
    
    
    
    
    rc = pthread_create(&id, NULL, printPositve, (void*) &my_array);
    pthread_join(id,NULL);
    
    rc = pthread_create(&id1, NULL, printNegative, (void*) &my_array);
    pthread_join(id1,NULL);
    
    rc = pthread_create(&id2, NULL, printZero, (void*) &my_array);
    pthread_join(id2,NULL);
    
    rc = pthread_create(&id3, NULL, printSum, (void*) &my_array);
    pthread_join(id3,NULL);
    
    rc = pthread_create(&id4, NULL, printAverage, (void*) &my_array);
    pthread_join(id4,NULL);
    
    rc = pthread_create(&id5, NULL, reverseArray, (void*) &my_array);
    pthread_join(id5,NULL);
    
    

   if (rc){
      cout << "ERROR; return code from pthread_create() is " << rc << endl;
      return -1;
   }

    
   pthread_exit(0);

}
