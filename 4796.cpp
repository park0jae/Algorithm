#include <iostream>
using namespace std;

int main()
{
    int l,p,v;

   
    int tc = 1;
    int cnt = 0;
    while(1){
        cnt = 0;
        
        cin >> l >> p >> v;
        
        if(l==0 && p == 0 && v==0)
            break;
        while(v>0)
        {
            if(v<l)
            {
                cnt += v;
                v = 0;
                break;
            }
            v = v - l;
            cnt += l;
            v= v- (p-l);
        }
        
        cout << "Case " << tc << ": " << cnt << endl;  
        tc++;
    }
    

    return 0;
}
