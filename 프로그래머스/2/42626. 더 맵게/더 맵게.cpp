#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    int len = scoville.size();
    
    priority_queue<int,vector<int>, greater<int>> pq;
    
    for(int i=0; i<len; i++){
        pq.push(scoville[i]);
    }
    
    
    while(1){
        if(pq.top() >= K){
            break;
        }
        int x = pq.top();
        pq.pop();
        int y = pq.top();
        pq.pop();
        int sum = x + (y * 2);
        
        pq.push(sum);
        answer++;
        
        len = pq.size();
        
        if(len < 2 && pq.top() <= K){
            answer = -1;
            break;
        }
    }        
    return answer;
}