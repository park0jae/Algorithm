#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int timer = 0;

bool compare(vector<int>&a, vector<int>& b){
    return a[1] <= b[1];
}

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    int cnt = jobs.size();
    sort(jobs.begin(), jobs.end() , compare);
    
    while(!jobs.empty()){
        for(int i=0; i<jobs.size(); i++){
            // 타이머 >= 업무 요청 시간 
            if(timer >= jobs[i][0]){
                // 업무 걸리는 시간 +
                timer += jobs[i][1];
                answer += timer - jobs[i][0];
                jobs.erase(jobs.begin() + i);
                break;
            }
            if(i == jobs.size() - 1) timer++;
        }
    }
    
    return answer/cnt;
}