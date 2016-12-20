
#include <iostream> 
#include <unistd.h>
using namespace std;


int main() 
{
 
 char* arr[] = {(char *)"ls", (char *)"-al", (char *)NULL};
 
pid_t id = fork(); 

if(id == -1) 
{
     cout << "Error creating process\n";
} 
else if (id == 0) {
     
     cout << "I am a child process!\n";
     cout <<"I'm bored of my parent now....switching programs"<<endl;
     execvp(arr[0], arr); //Switch the child memory image from the parent.
} 
else {
     cout << "I just became a parent!\n";
} 
return 0;
}
     