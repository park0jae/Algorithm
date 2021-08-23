#include <iostream>
#include <vector>
using namespace std;

int n,m;
bool visited[101][101];

void dfs(vector<vector<char>> &v , int x, int y , char a)
{
    if(x>=n || y>=m || visited[x][y]) return;
    
    if(a == '-')
    {
        if(v[x][y] != '-') return;
    }
    else
    {
        if(v[x][y] != '|') return;
    }
    visited[x][y] = 1;
    if(a == '-')
    {
        dfs(v,x,y+1,'-');
    }
    else
    {
        dfs(v,x+1,y,'|');
    }
}

int main()
{
    
    int cnt = 0;
    cin >> n >> m;

    vector<vector<char>> v(n+1,vector<char>(m+1));


    for(int i=0; i<n; i++)
    {
        for(int j=0; j<m; j++)
        {
            cin >> v[i][j];
        }
    }
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<m; j++)
        {
            if(!visited[i][j])
            {
                cnt++;
                if(v[i][j] == '-') 
                    dfs(v,i,j,'-');
                else
                    dfs(v,i,j,'|');
            }
        }
    }
    cout << cnt;

    return 0;

}
