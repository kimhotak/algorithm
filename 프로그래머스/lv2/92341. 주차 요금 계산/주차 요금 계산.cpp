#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> fees, vector<string> records) {
    map<int,int> time;
    for (string str: records) {
        stringstream ss(str);
        int h, m, num;
        char c;
        string type;
        ss >> h >> c >> m >> num >> type;
        m += 60 * h;
        if (type == "IN") time[num] -= m;
        else time[num] += m;
    }
    
    vector<int> answer;
    for (auto& kv : time) {
        if (kv.second <= 0) kv.second += 23 * 60 + 59;
        int fee = fees[1];
        if (kv.second > fees[0]) {
            fee += ((kv.second - fees[0] - 1) / fees[2] + 1) * fees[3];
        }
        answer.push_back(fee);
    }
    return answer;
}