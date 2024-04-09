#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp (int num1 , int num2){
    string str1 = to_string(num1);
    string str2 = to_string(num2);
    
    if(stoi(str1+str2) > stoi(str2+str1))
    {
        return true;
    }
    else return false;
    
}

string solution(vector<int> numbers) {
    string answer = "";
    
    if(numbers.size() == 1)
        return answer += to_string(numbers[0]);
    sort(numbers.begin(), numbers.end(), cmp);
    if(numbers[0] == 0) return answer+=to_string(0);    
    for(int i=0; i<numbers.size(); i++)
    {
        answer += to_string(numbers[i]);
    }
    
    return answer;
}