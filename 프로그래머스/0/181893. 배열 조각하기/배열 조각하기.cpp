#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    
    int odd = 0, even = arr.size()-1;
    for (int i = 0; i < query.size(); i++) {
        if (i&1) odd += query[i];
        else even = odd + query[i];
    }
    
    vector<int> answer;
    for (int i = odd; i <= even; i++) answer.push_back(arr[i]);
    return answer;
}