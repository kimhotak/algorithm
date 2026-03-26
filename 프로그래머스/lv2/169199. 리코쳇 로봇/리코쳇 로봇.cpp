#include<bits/stdc++.h>
#define R first
#define C second

using namespace std;
using pii = pair<int,int>;

bool oob(int r, int c, int nr, int nc) {
    return r < 0 || nr <= r || c < 0 || nc <= c;
}

int solution(vector<string> board) {
    int nr = board.size(), nc = board[0].size();
    pii start, goal;
    for (int r = 0; r < nr; r++) {
        for (int c = 0; c < nc; c++) {
            if (board[r][c] == 'R') start = {r, c};
            if (board[r][c] == 'G') goal = {r, c};
        }
    }
    
    queue<pii> q;
    vector<vector<int>> dist(nr, vector<int>(nc, -1));
    q.push(start);
    dist[start.R][start.C] = 0;
    int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
    
    while (!q.empty()) {
        pii cur = q.front();
        if (cur == goal) break;
        q.pop();
        for (int i = 0; i < 4; i++) {
            pii next = {cur.R, cur.C};
            while (!oob(next.R + dr[i], next.C + dc[i], nr, nc) &&
                   board[next.R + dr[i]][next.C + dc[i]] != 'D') {
                next.R += dr[i];
                next.C += dc[i];
            }
            if (dist[next.R][next.C] != -1) continue;
            dist[next.R][next.C] = dist[cur.R][cur.C] + 1;
            q.push(next);
        }
    }
    
    return dist[goal.R][goal.C];
}