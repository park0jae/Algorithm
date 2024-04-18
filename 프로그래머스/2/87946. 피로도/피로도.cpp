#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool check[9];
int answer = -1;  


void dfs(int k, int pos, vector<vector<int>> dungeons){
    
    if(k < 0) {
        return ;
    }
    for(int i=0; i<dungeons.size(); i++){
        if(!check[i] && k >= dungeons[i][0]){
            check[i] = true;
            dfs(k-dungeons[i][1] , pos+1, dungeons);
            check[i] = false;
        }
    }
    answer = max(answer, pos);
}


int solution(int k, vector<vector<int>> dungeons) {
    
    dfs(k, 0, dungeons);
    
    return answer;
}