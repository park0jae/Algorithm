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

    
    if(result<10) 
    {
        cout << "0" << result << endl;
    }
    else    
        cout << result << endl;

    return 0;
}
