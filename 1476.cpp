#include <iostream>
using namespace std;

int main()
{
    int E,S,M;
    int e,s,m;
    cin >> E >> S >> M;
    int year = 1;
    
    e=1;
    s=1;
    m=1;    // 두개가 범위 끝에 겹치는 경우도 생각해야함.
    if(E ==1 && S==1 && M==1)
        year = 1;
    else{

        while(1)
        {
            if(e==E && s==S && m==M)
                break;
                 
            if(e==15 && s!= 28 && m!= 19)
            {
                e=1;
                s++;
                m++;
                year++;
            }
            else if(e!=15 && s==28 && m!=19)
            {
                e++;
                s=1;
                m++;
                year++;
            }
            else if(e!=15 && s!= 28 && m==19)
            {
                e++;
                s++;
                m=1;
                year++;    
            }
            else if(e==15 && s==28 && m!= 19)
            {
                e=1;
                s=1;
                m++;
                year++;
            }
            else if(e==15 && s!=28 && m==19)
            {
                e=1;
                s++;
                m=1;
                year++;
            }
            else if(e!=15 && s==28 && m==19)
            {
                e++;
                s=1;
                m=1;
                year++;
            }
            else if(e!=15 && s!= 28 && m!=19)
            {
                e++;
                s++;
                m++;
                year++;  
            }
            
        }
    }
    cout << year << endl;

    return 0;
}
