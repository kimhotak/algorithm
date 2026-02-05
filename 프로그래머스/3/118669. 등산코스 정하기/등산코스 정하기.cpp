#include<bits/stdc++.h>
#define pii pair<int,int>

using namespace std;

vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    // (간선들 중 가장 긴 가중치)가 가장 작은것을 고른다.
    vector<int> answer = {-1, INT32_MAX};
    
    // 그래프화 graph[i] = {w, j};
    vector<vector<pii>> graph(n+1, vector<pii>());
    for(vector<int> path: paths) {
        graph[path[0]].push_back({path[2], path[1]});
        graph[path[1]].push_back({path[2], path[0]});
    }
    
    // 타입 구분 1-index로 통일
    vector<int> nodeType(n+1,0); // 0: 휴식, 1: 출입구, 2: 산봉우리;
    for (int g: gates) nodeType[g] = 1;
    for (int s: summits) nodeType[s] = 2;
    
    
        
    // intensity, node
    priority_queue<pii, vector<pii>, greater<pii>> pq;
    vector<int> dist(n+1, INT32_MAX);

    for (int gate: gates) {
        pq.push({0, gate});
        dist[gate] = 0;
    }
    
    while (!pq.empty()) {
        pii cur = pq.top();
        pq.pop();
        if (dist[cur.second] < cur.first) continue;

        for (pii edge: graph[cur.second]) {
            pii next = {max(cur.first, edge.first), edge.second};

            if (dist[next.second] <= next.first) continue;
            dist[next.second] = next.first;

            if (nodeType[next.second] == 0) { // 휴식
                pq.push(next);
            }
        }
    }

    for (int summit: summits) {
        if (answer[1] > dist[summit] ||
            (answer[1] == dist[summit] && answer[0] > summit)) {
            answer[0] = summit;
            answer[1] = dist[summit];
        }
    }
    
    return answer;
}