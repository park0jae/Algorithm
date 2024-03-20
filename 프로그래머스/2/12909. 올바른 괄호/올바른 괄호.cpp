#include<string>
#include <iostream>
#include <stack>

using namespace std;

int open = 0;
int close = 0;

bool solution(string s)
{
    bool answer = true; 
    stack<char> st;
    
    if(s.size() % 2 != 0) return false;
    
    for(int i=0; i<s.size(); i++){
        if(st.empty()){
            if(s[i] == ')') return false;
            else st.push(s[i]);
        }else {
            if(s[i] == ')'){
                if(!st.empty() && st.top() == '(') st.pop();
            }else {
                st.push(s[i]);
            }
        }
    }
    if(!st.empty()) answer = false;

    return answer;
}