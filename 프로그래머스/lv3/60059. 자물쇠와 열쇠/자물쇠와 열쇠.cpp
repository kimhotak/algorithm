#include<bits/stdc++.h>

using namespace std;

void rotate(vector<vector<int>> &v) {
    // 시계방향 90도 회전
    vector<vector<int>> copy(v);
    int n = copy.size();
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            v[c][n-r-1] = copy[r][c];
        }
    }
}

bool oob(int r, int c, int nr, int nc) {
    return r < 0 || nr <= r || c < 0 || nc <= c;
}

bool isUnlock(vector<vector<int>> &key, vector<vector<int>> &lock, int sr, int sc) {
    int n = lock.size(), m = key.size();
    
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            
            // r, c 자물쇠의 좌표, sr,sc key를 시작하는 부분의 좌표
            int keyr = r - sr, keyc = c - sc;
            // 자물쇠의 부분이 키와 안겹치는 부분인지
            bool outOfKey = oob(keyr, keyc, m, m);
            
            if ((outOfKey && lock[r][c] == 0) ||
                (!outOfKey && key[keyr][keyc] == lock[r][c])) {
                // 열쇠 안맞는 경우
                return false;
            }
        }
    }
    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    int n = lock.size(), m = key.size();
    
    for (int degree = 0; degree < 4; degree++) { // 회전
        if (degree != 0) rotate(key);
    
        for (int r = 1 - m; r < m + n; r++) { // 수직 평행이동
            for (int c = 1 - m; c < m + n; c++) { // 수평 평행이동
                // lock의 0,0에 대한 key의 상대좌표 r,c
                if (isUnlock(key, lock, r, c)) return true;
            }
        }
    }
    
    return false;
}