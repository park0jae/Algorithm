#include <iostream>
#include <algorithm>
using namespace std;

// a>b 인 경우 a=b인 경우를 생각해야 하는 문제였음.

int main()
{
    long long a,b;
    cin >> a >> b;
    
    if(a > b)
        swap(a,b);
    if(a != b)
    {
        cout << b-a-1 << endl;
        for(long long i = a+1; i<b; i++)
        {
            cout << i << ' ';
        }
    }
    else
        cout << 0 << endl;

    return 0;
}
