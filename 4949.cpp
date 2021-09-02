#include <iostream>
#include <stack>
#include <string>
using namespace std;


stack<char> bal;

int check = 1;
int main()
{
    string s;
    while(1)
    {
        getline(cin,s);
        if(s.size() == 1 &&s[0] == '.') break;
        
        for(int i=0; i<s.size(); i++)
        {
            if(s[i] == '(' || s[i] == '[' || s[i] == ')' || s[i] == ']') 
               if(bal.empty()) 
                bal.push(s[i]);
            else{
                if(s[i] == ')' && bal.top() == '(')
                    bal.pop();
                else if(s[i] == ']' && bal.top() == '[')
                    bal.pop();
                else   
                    bal.push(s[i]);
            }
        }
        if(!bal.empty())
        {
            cout << "no" << '\n';
            while(!bal.empty ())   
            {
                bal.pop();
            }
        }
        else
            cout << "yes" << '\n';
      
        check = 1;
    }



    return 0;

}
