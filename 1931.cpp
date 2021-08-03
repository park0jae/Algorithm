#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(pair<int,int>&a , pair<int,int>& b)
{
    if(a.second == b.second) return a.first < b.first;
    return a.second < b.second;
}

int main()
{

    int n;
    int cnt = 0;
    int start = 0;
    cin >> n;

    vector<pair<int,int>> v(n);

    for(auto& p : v)
    {
        cin >> p.first >> p.second;
    }

    sort(v.begin(),v.end(),compare);
    
    for(int i=0; i<n; i++){
        if(start <= v[i].first)
        {
            start = v[i].second;
            cnt++;
        }   
    }
    cout << cnt << endl;

    return 0;
}
