#include <string>
#include <vector>
#include <algorithm>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<vector<int>> score) {
    vector<int> sum(score.size());
    for (int i = 0; i < score.size(); i++) {
        sum[i] = (score[i][0] + score[i][1]);
    }
    sort(sum.begin(), sum.end());
    
    for (int i: sum) cout << i << ' ';
    
    
    vector<int> answer(score.size());
    for (int i = 0; i < score.size(); i++) {
        answer[i] = sum.end() - upper_bound(sum.begin(), sum.end(), (score[i][0] + score[i][1])) + 1;
    }
    
    return answer;
}