#include <iostream>
using namespace std;

int main()
{
    int n , k;
    int a;
    int coin[11];
    int max;
    int min_coin = 0;
    cin >> n >> k;
    
    for(int i=0; i<n; i++)
    {
        cin >> a;
        coin[i] = a;
    }

    for(int i=n-1; i>=0; i--)
    {
        if(k >= coin[i])
        {
            max = coin[i];
            while( k>= max)
            {
                k -= max;
                min_coin++;
            }
        }
    }
    cout << min_coin << endl;

    return 0;

}
