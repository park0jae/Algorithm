#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<int>& numbers, int target , int sum , int pos)
{
    if(pos == numbers.size() - 1)
    {
        if(target == numbers[pos] + sum) answer++;
        if(target ==  sum - numbers[pos] ) answer++;
        
        return ;
    }
    
    dfs(numbers, target , sum + numbers[pos], pos+1);
    dfs(numbers, target , sum - numbers[pos], pos+1);
    
}
    

int solution(vector<int> numbers, int target) {
    
    dfs(numbers, target , 0 , 0);
    return answer;
}