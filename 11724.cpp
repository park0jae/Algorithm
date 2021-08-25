#include <iostream>
#include <vector>
using namespace std;

#define MAX_SIZE 1001
int n , m;
bool visited[MAX_SIZE];
int map[MAX_SIZE][MAX_SIZE];

void dfs(int a)
{
    for(int i=1; i<=n; i++)
    {
        if(map[a][i] == 1 && visited[i] == false)
        {
            visited[i] = true;
            dfs(i);
        }
    }

}
int main(){

    // n은 정점의 개수 , m은 간선의 개수
    
    cin >> n >> m;
    int u,v;
    int cnt = 0;
    
    for(int i=0; i<m; i++)
    {
        cin >> u >> v;
        map[u][v] = 1;
        map[v][u] = 1;
    }
    for(int i=1; i<=n; i++)
    {
        if(!visited[i])
        {
            dfs(i);
            cnt++;
        }
    }

    cout << cnt << endl;


    return 0;

}
