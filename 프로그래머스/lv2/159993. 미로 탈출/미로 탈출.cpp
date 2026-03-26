#include<bits/stdc++.h>
#define R first
#define C second
using namespace std;

static int dr[] = {-1, 1, 0, 0}, dc[] = {0,0,-1,1};

int mindist(pair<int,int> from, pair<int,int> to, vector<string>& maps) {
    deque<pair<int,int>> dq;
    vector<vector<int>> dist(maps.size(), vector<int>(maps[0].size(),-1));
    dq.push_back(from);
    dist[from.R][from.C] = 0;
    while (!dq.empty()) {
        pair<int,int> cur = dq.front();
        if (cur == to) break;
        dq.pop_front();
        for (int i = 0; i < 4; i++) {
            pair<int,int> next = {cur.R + dr[i], cur.C + dc[i]};
            if (next.R < 0 || maps.size() <= next.R ||
                next.C < 0 || maps[next.R].size() <= next.C ||
                dist[next.R][next.C] != -1 ||
                maps[next.R][next.C] == 'X') continue;
            dist[next.R][next.C] = dist[cur.R][cur.C] + 1;
            dq.push_back(next);
        }
    }
    
    return dist[to.R][to.C];
}

int solution(vector<string> maps) {
    // s -> l -> e 순 방문
    pair<int,int> s, l, e;
    for (int r = 0; r < maps.size(); r++) {
        for (int c = 0; c < maps[r].size(); c++) {
            if (maps[r][c] == 'S') s = {r, c};
            else if (maps[r][c] == 'L') l = {r, c};
            else if (maps[r][c] == 'E') e = {r, c};
        }
    }
    int s2l = mindist(s, l, maps);
    int l2e = mindist(l, e, maps);
    int answer;
    if (s2l == -1 || l2e == -1) answer = -1;
    else answer = s2l + l2e;
    return answer;
}

