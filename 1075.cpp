#include <iostream>
using namespace std;

int main()
{
    int n,f;
    int result;
    cin >> n >> f;

    n = n/100; // n의 맨 뒷자리를 00으로 만들기 위한 과정
    n = n*100;

    while(1)
    {
        if(n%f == 0) break;
        n++;
    }
    result = n % 100;

    if(n<0) 
    {
        cout << "0" << n << endl;
    }
    else    
        cout << n << endl;

    return 0;
}
