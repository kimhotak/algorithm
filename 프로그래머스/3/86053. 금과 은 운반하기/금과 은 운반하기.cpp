#include<bits/stdc++.h>

using namespace std;
using ll = long long;

ll solution(int a, int b, vector<int> g, vector<int> s, vector<int> w, vector<int> t) {
    int n = g.size();
    ll lo = 0, hi = (ll)(a + b) * 200000;
    // a + b 개를 1개 씩 편도 100_000시간 걸려서 옮기는 최대시간
    cout << hi;
    while (lo <= hi) {
        ll mid = lo + (hi - lo) / 2;
        
        // 가능한지 체크
        ll gold = 0, silver = 0, weight = 0;
        for (int i = 0; i < n; i++) {
            ll move = (mid + t[i]) / (t[i]<<1) * w[i]; // 옮길 수 있는 무게
            gold += min(move, (ll)g[i]);
            silver += min(move, (ll)s[i]);
            weight += min(move, (ll)g[i] + (ll)s[i]);
        }
        bool flag = gold >= a && silver >= b && weight >= a+b;
        
        if (flag) hi = mid - 1;
        else lo = mid + 1;
    }
    
    return lo;
}