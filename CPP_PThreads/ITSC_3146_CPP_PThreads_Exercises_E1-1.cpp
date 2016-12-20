#include <pthread.h>
#include <iostream>
using namespace std;

//Global variables
const int arrayLength = 4;
int indexNum[arrayLength] = {};
const char* my_messages[arrayLength] = {"English: Hello!", "French: Bonjour!", "Spanish: Hola!", "German: Guten Tag!"};

// This function implements the routine that is
// executed by the thread
void *printMessage(void *index)
{
   // TODO: Add code that implements
   //       the thread's functionality
   //int actual_arg = *((int*) (&index)); //Also works. Gets the value pointed to by what we get when we take the address of index and cast it to int* pointer? 
   
   //Get the passed in parameter (void* can be cast to long but not to int)
   long actual_arg = (long)index;
   
   //Print out the message at the specified index
   std::cout << my_messages[(int)actual_arg] << endl;
   
   return 0; //   pthread_exit(0);
}


int main()
{
   // id is used to store a unique thread identifier,
   // returned by the call to create a new POSIX thread
   pthread_t id;
   
   // rc is used to store the code returned by the
   // call to create a new POSIX thread. The value is
   // zero (0) if the call succeeds.
   int rc;

   // TODO: Add code to perform any needed initialization
   //       or to process user input
   
   // Create thread(s)
   // TODO: Modify according to assignment requirements
   
   //Loop to create a thread for each element in my_messages array
   for (int i = 0; i < arrayLength; i++) {
      //index to pass in will be the same number as the current loop iteration
      indexNum[i] = i; 
      
      //get the value of the index to pass in and put it in new long
      long index = (long)(indexNum[i]); 
      
      //rc = pthread_create(&id, NULL, printMessage, (void*) &index); <-- Doesn't Work. (Passes a pointer to index (&index), the value of which changes and causes the threads to use incorrect index #'s)
      
      //Create thread and pass in the index
      rc = pthread_create(&id, NULL, printMessage, (void *) index);
   }

   if (rc){
      cout << "ERROR; return code from pthread_create() is " << rc << endl;
      return -1;
   }
   

   // NOTE: Using exit here will immediately end execution of all threads
   pthread_exit(0);
}