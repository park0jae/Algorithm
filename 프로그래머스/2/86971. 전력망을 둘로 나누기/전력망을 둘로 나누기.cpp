#include <string>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

vector<int> graph[101];
pair<int,int> except[101];
int groupCnt;
int visitCnt[2];
int answer = 80808080;

bool visited[101];

bool exceptCheck(int exceptIdx, int cur, int next){
    int from = except[exceptIdx].first;
    int to = except[exceptIdx].second;
    if((from == cur && to == next) || (to == cur && from == next)){
        return true;
    }
    return false;
}

void dfs(int exceptIdx, int cur){
    visited[cur] = true;
    visitCnt[groupCnt]++;
    for(int i=0; i<graph[cur].size(); i++){
        int next = graph[cur][i];
        if(exceptCheck(exceptIdx, cur, next)) continue;
        if(visited[next]) continue;
        dfs(exceptIdx, next);
    }
}

int solution(int n, vector<vector<int>> wires) {
    int k = 0;
    for(auto wire : wires){
        graph[wire[0]].push_back(wire[1]);
        graph[wire[1]].push_back(wire[0]);
        
        except[k++] = {wire[0] , wire[1]};
    }
    for(int i=0; i<wires.size(); i++){
        for(int j=1; j<=n; j++){
            if(visited[j]) continue;
            dfs(i,j);
            groupCnt++;
        }
        if(groupCnt == 2){
            answer = min(answer, abs(visitCnt[0] - visitCnt[1]));
        }
        groupCnt = 0;
        visitCnt[0] = visitCnt[1] = 0;
        memset(visited, false, sizeof(visited));
    }
    
    return answer;
}