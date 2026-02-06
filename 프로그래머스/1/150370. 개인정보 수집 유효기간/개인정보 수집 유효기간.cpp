#include<bits/stdc++.h>

using namespace std;

int ymd2daycount(string ymd) {
    stringstream ss(ymd);
    int y, m, d;
    char c;
    ss >> y >> c >> m >> c >> d;
    return ((y * 12) + m) * 28 + d;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    
    map<char, int> type_term;
    for (string str: terms) {
        stringstream ss(str);
        char c;
        int m;
        ss >> c >> m;
        type_term[c] = m * 28;
    }
    
    int today_count = ymd2daycount(today);
    vector<int> answer;
    
    for (int i = 0; i < privacies.size(); i++) {
        stringstream ss(privacies[i]);
        string ymd;
        char type;
        ss >> ymd >> type;
        if (today_count >= ymd2daycount(ymd) + type_term[type]) answer.push_back(i+1);
    }
    
    return answer;
}