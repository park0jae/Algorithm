#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    
    int n,l;
    int w;
    int water[1001];
    int min_w;
    int cnt = 1;
    cin >> n >> l;

    for(int i=0; i<n; i++)
    {
        cin >> w;
        water[i] = w;
    }
    // 정렬 
    sort(water,water+n);
    
    min_w = water[0];
    for(int i=1; i<n; i++)
    {
        // 양옆 0.5 = 1 -> 테이프길이 -1 보다 두 지점 사이의 거리가 
        // 길면 기준점 초기화 
        if(water[i] - min_w > l-1 )
        {
            min_w = water[i];
            cnt++;
        }
    }

    cout << cnt << endl;



    return 0;
}
