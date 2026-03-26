#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    priority_queue<int> maxq;
    priority_queue<int, vector<int>, greater<int>> minq;
    map<int,int> show;
    int len = 0;
    for (string op: operations) {
        stringstream ss(op);
        char c;
        int n;
        ss >> c >> n;
        if (c == 'I') {
            maxq.push(n);
            minq.push(n);
            show[n]++;
            len++;
        }
        else if (len != 0 && n == 1) {
            while (show[maxq.top()] <= 0) maxq.pop();
            show[maxq.top()]--;
            len--;
            maxq.pop();
        }
        else if(len != 0 && n == -1) {
            while (show[minq.top()] <= 0) minq.pop();
            show[minq.top()]--;
            len--;
            minq.pop();
        }
    }
    if (len == 0) {
        answer.push_back(0);
        answer.push_back(0);
    }
    else {
        while (show[maxq.top()] <= 0) maxq.pop();
        while (show[minq.top()] <= 0) minq.pop();
        answer.push_back(maxq.top());   
        answer.push_back(minq.top());
    }
    
    return answer;
}