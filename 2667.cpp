#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

string map[25];
int visited[25][25] = { 0, };
int n;
int cnt;
int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};
int danzi_num=0;

void reset_visit()
{
    for(int i=0; i<25; i++)
    {
        for(int j=0; j<25; j++)
        {
            visited[i][j] = 0;
        }
    }
}

vector<int> v;

void dfs(int y , int x)
{
    visited[y][x] = 1;
    
    danzi_num++;
    for(int i=0; i<4; i++)
    {
        int ny = y+dy[i];
        int nx = x+dx[i];
        if(ny >= 0 && nx>= 0 && nx<n && ny<n)
        {
            if(map[ny][nx] == '1' && visited[ny][nx] == 0)
            {
                dfs(ny,nx);
            }
        }
    }

}

int main()
{   
    cin >> n;
        
    for(int i=0; i<n; i++)
    {
       
        cin >> map[i];
            
    }
    reset_visit();

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++)
        {
            if(map[i][j] == '1' && visited[i][j]==0)
            {
                danzi_num = 0;
                cnt++;
                dfs(i,j);
                v.push_back(danzi_num);
            }
        }
    }
    sort(v.begin(),v.end());

    cout << cnt << endl;
    

    for(int i=0; i<v.size(); i++)
    {
        cout << v[i] << endl;        
    }    
    
    return 0;
}
