#include <iostream>
#include <queue>
using namespace std;

int visited[1001];
 // 정점 개수 , 간선 개수 , 시작 정점
int map[1001][1001];
int n , m , v;

void reset_visit()
{
    for(int i=0; i<1001; i++)
    {
        visited[i] = 0;
    }
}

void dfs(int v)
{
    visited[v] = 1;
    cout << v << " ";
    for(int i=1; i<=n; i++)
    {
        if(!visited[i] && map[v][i])
            dfs(i);
    }
}

void bfs(int v)
{
    queue<int> q;
    q.push(v);
    visited[v] = 1;
    
    while(!q.empty())
    {
        v=q.front();
        cout << q.front() << " ";
        q.pop();
        for(int i=1; i<=n; i++)
        {
            if(!visited[i] && map[v][i])
            {
                q.push(i);
                visited[i] = 1;
            }
        }
    }

}


int main()
{

    int a,b;
    cin >> n >> m >> v;
   
    while(m--)
    {
        cin >> a >> b;
        map[a][b] = 1;
        map[b][a] = 1;
    }
    dfs(v);
    cout << '\n';
    reset_visit();
    bfs(v);



    return 0;

}
