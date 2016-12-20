#include <iostream>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>


#define TOTAL_THREADS 4


int count;
pthread_mutex_t the_mutex = PTHREAD_MUTEX_INITIALIZER; //  phread mutex variable


void* myFunction(void* arg)
{
	int actual_arg = *((int*) arg);
    
	for(unsigned int i = 0; i < 10; ++i) {
        
        //  TODO:
        //  Use a Pthread mutex to control
        //  access to the critical region.
          pthread_mutex_lock(&the_mutex);
          
        //  Beginning of the critical region
        count++;
        std::cout << "Thread #" << actual_arg << " count = " << count << std::endl;
        
        //  End of the critical region
        pthread_mutex_unlock(&the_mutex);
        
	}
    
	pthread_exit(NULL);
}


int main()
{
    int rc[TOTAL_THREADS];
    pthread_t ids[TOTAL_THREADS];
    int args[TOTAL_THREADS];
    
    //Initialized on line 11.
    //  TODO: Initialize the pthread mutex here
    //pthread_mutex_init();
   //PTHREAD_ERRORCHECK_MUTEX_INITIALIZER_NP; //ERROR CHECK THE MUTEX. PTHREAD_MUTEX_LOCK WILL RETURN EDEADLK IF DEADLOCKED
    
    count = 0;
    for(unsigned int i = 0; i < TOTAL_THREADS; ++i) {
        args[i] = i;
        rc[i] = pthread_create(&ids[i], NULL, myFunction, (void*) &args[i]);
    }
    
    for(unsigned int i = 0; i < TOTAL_THREADS; ++i) {
        pthread_join(ids[i], NULL);
    }
    
    std::cout << "Final count = " << count << std::endl;
    pthread_exit(NULL);
}
