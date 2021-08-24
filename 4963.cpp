#include <iostream>
#include <queue>
using namespace std;

int w,h;
int map[50][50];
int visited[50][50];

int dx[8] = {1,0,-1,0,1,1,-1,-1};
int dy[8] = {0,1,0,-1,-1,1,-1,1};

void reset_visit()
{
    for(int i=0; i<50; i++)
        for(int j=0; j<50; j++)
        {
            visited[i][j] = 0;
            map[i][j] = 0;
        }

}
/*
void bfs(int y , int x)
{
    visited[y][x] = 1;
    queue <pair<int,int>> q;
    q.push(make_pair(y,x));
    while(!q.empty())
    {
        y = q.front().first;
        x = q.front().second;
        q.pop();
        for(int i=0; i<8; i++)
        {
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny>=0 && nx>= 0 && nx<50&& ny <50)
            {
                if(map[ny][nx] && !visited[ny][nx])
                {
                    visited[ny][nx] = 1;
                    q.push(make_pair(ny,nx));
                }
            }
        }
    }
*/
void dfs(int y, int x){

    visited[y][x] = 1;
    for(int i=0; i<8; i++)
    {
        int ny = y+dy[i];
        int nx = x+dx[i];

        if(nx >= 0 && ny>=0 && nx < w  && ny < h){
            if(map[ny][nx] && !visited[ny][nx])
            {
                visited[ny][nx] = 1;
                dfs(ny,nx);
            }
        }
    }
}

int main()
{
    int cnt = 0;
    while(1)
    {
        cin >> w >> h;
    
        if(w == 0 && h == 0)
            break;
        for(int i=0; i<h; i++)
        {
            for(int j=0; j<w; j++)
                cin >> map[i][j];
        }
        for(int i=0; i<h; i++)
            for(int j=0; j<w; j++)
            {
                if(map[i][j] == 1 && !visited[i][j])
                {
                    cnt++;
                    dfs(i,j);
                  //bfs(i,j);
                }
            }
        cout << cnt << endl;
        cnt = 0;
        reset_visit();
    }    
}
