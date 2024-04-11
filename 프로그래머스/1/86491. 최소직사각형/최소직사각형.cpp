#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int max_w = 0;
    int max_h = 0;
        
    for(auto &size : sizes){
        max_w = max(max_w, max(size[0], size[1]));
        max_h = max(max_h, min(size[0], size[1]));
    }
    
    return max_w * max_h;
    
}