
#include <iostream>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
using namespace std;

int main()
{
	pid_t id = fork();
	//REF https://www.experts-exchange.com/questions/24706598/Unbuffered-output-with-cout.html
	//REF http://www.csl.mtu.edu/cs4411.ck/www/NOTES/process/fork/create.html
        ::cout.setf(std::ios::unitbuf); // Remove buffering 
        
	if(id == -1) {
		cout << "Error creating process\n"<<endl;
	} else if (id == 0) {
		cout << "I am a child process!\n"<<endl;
		sleep(5);
		cout <<"\nMy PID is:"<<getpid()<<endl;
		sleep(5);
		cout <<"The PID of my parent is: "<<getppid()<<endl;
	} else {
		
		cout << "I just became a parent!\n"<<endl;
		pid_t wait(int *status);
		sleep(5);
		cout <<"My child process just terminated!"<<endl;
		
	}

	return 0;
}
