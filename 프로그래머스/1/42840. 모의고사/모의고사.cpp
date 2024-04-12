#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int one[6]= {1,2,3,4,5};
int two[11] = {2,1,2,3,2,4,2,5};
int three[11] = {3,3,1,1,2,2,4,4,5,5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int one_sum = 0;
    int two_sum = 0;
    int three_sum = 0;

    for(int i=0; i<answers.size(); i++){
        
        if(one[i%5] == answers[i]) one_sum++;
        if(two[i%8] == answers[i]) two_sum++;
        if(three[i%10] == answers[i]) three_sum++;  
        
       
    }
    if(one_sum > two_sum){
        if(one_sum > three_sum) answer.push_back(1);
        else if(one_sum == three_sum){
            answer.push_back(1);
            answer.push_back(3);
        }else {
            answer.push_back(3);
        }
    }else if(one_sum == two_sum){
        if(one_sum > three_sum){
            answer.push_back(1);
            answer.push_back(2);
        }else if(one_sum == three_sum){
            answer.push_back(1);
            answer.push_back(2);
            answer.push_back(3);
        }else {
            answer.push_back(3);
        }
    }else {
        if(two_sum > three_sum) answer.push_back(2);
        else if(two_sum == three_sum){
            answer.push_back(2);
            answer.push_back(3);
        }else {
            answer.push_back(3);
        }
    }
 
    
    return answer;
}