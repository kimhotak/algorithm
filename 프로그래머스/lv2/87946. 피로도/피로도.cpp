#include<bits/stdc++.h>

using namespace std;

static vector<vector<int>> dg;
int bt(int st, vector<bool> used) {
    int res = 0;
    for (bool b: used) if (b) res++; 
    for (int i = 0; i < dg.size(); i++) {
        if (used[i] || st < dg[i][0]) continue;
        vector<bool> nu(used);
        nu[i] = true;
        res = max(res, bt(st - dg[i][1], nu));
    }
    return res;
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    dg = dungeons;
    vector<bool> enterd(dungeons.size(), false);
    
    return bt(k, enterd);
}