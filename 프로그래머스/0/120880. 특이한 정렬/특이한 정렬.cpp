#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> numlist, int n) {
    vector<int> answer;
    
    sort(numlist.begin(), numlist.end());
    int ni = lower_bound(numlist.begin(), numlist.end(), n) - numlist.begin();
    
    int l = ni -1, r = ni;
    
    while (0 <= l || r < numlist.size()) {
        if (l < 0) answer.push_back(numlist[r++]);
        else if (r >= numlist.size()) answer.push_back(numlist[l--]);
        else if (numlist[r] - n <= n - numlist[l]) answer.push_back(numlist[r++]);
        else if (numlist[r] - n > n - numlist[l]) answer.push_back(numlist[l--]);
    }
    return answer;
}