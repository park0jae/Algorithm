#include <iostream>
using namespace std;

int main()
{
    string s;
    int alp[26] = { 0, };
    int max = 0;
    char max_alp;
    cin >> s;

    for(int i=0; i<s.size(); i++)
    {
        if(s[i] >= 'A' && s[i] <= 'Z')
            alp[s[i]-'A']++;
        if(s[i] >= 'a' && s[i] <= 'z')
            alp[s[i]-'a']++;
    }
   
    for(int i=0; i<26; i++)
    {  
        if(max < alp[i])
        {
            max = alp[i];
            max_alp =  i + 'A';
        }
        else if( max == s[i] )
        {
            max_alp= '?';      
        }
    }
    cout << max_alp << endl;
    return 0;
}
