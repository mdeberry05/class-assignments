#include <iostream>
#include <cstring>
#include <iterator>
#include <vector>
#include <sstream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

unsigned int countWordsInString(string const& str);

int main() {
    /**
     * Get the command string from the user.
     */
    string cmd_str; //declare cmd_str
    cout << "mshell> "; 
    getline(cin, cmd_str); //get user input
    
    /**
     * Parse command string and set up array of parameters (args)
     * to pass to execvp.
     */
     //REF http://www.cplusplus.com/reference/sstream/stringstream/
    stringstream ssin(cmd_str); 
    
    unsigned int tokenCount = countWordsInString(cmd_str);
    char** c_arr = new char *[tokenCount + 1]; //initialize
    c_arr[tokenCount] = (char*)NULL; //NULL Pointer
    
    int i = 0; //intiliazie for scope
    //REF http://stackoverflow.com/questions/17956939/array-size-and-split-of-string
    while (ssin.good() && i < tokenCount) {
        string buf;
        ssin >> buf;
        
        char* c_buf = new char[buf.length()];
        //http://www.cplusplus.com/reference/cstring/strcpy/
        strcpy(c_buf, buf.c_str());
        c_arr[i] = c_buf;
        ++i;
    }
    /**
     * Spawn a process to executethe user's command.
     */
    pid_t pid = fork();
    
    if (pid == -1) {
        cout << "Error creating process\n";
    }
    else if (pid == 0) {
        cout << "I am a child process!\n";
        
        // Iterate through cmd_str until a \0 character is encountered/
        int err = execvp(c_arr[0], c_arr);
        
        cout << "I'm bored of my parent now....switching programs" << endl;
    }
    else {
        cout << "I just became a parent!\n";
        int status;
        waitpid(pid, &status, 0);
    }
}
//REF http://stackoverflow.com/questions/3672234/c-function-to-count-all-the-words-in-a-string
unsigned int countWordsInString(string const& str)
{
    stringstream stream(str);
    return std::distance(std::istream_iterator<std::string>(stream), std::istream_iterator<std::string>());
}
