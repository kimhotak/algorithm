#include<bits/stdc++.h>

using namespace std;

static bool found;

void backtrack(string cur, map<string, vector<string>>& graph, vector<string>& path, int ticket_cnt) {
    if (path.size() == ticket_cnt + 1) {
        found = true;
        return;
    }
    
    for (int i = 0; i < graph[cur].size(); i++) {
        string next = graph[cur][i];

        if (next == "used") continue;

        graph[cur][i] = "used"; 
        path.push_back(next);
        
        backtrack(next, graph, path, ticket_cnt);
        if (found) return; 

        path.pop_back();
        graph[cur][i] = next; 
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    found = false;
    
    map<string,vector<string>> graph;
    for (vector<string> v: tickets) {
        graph[v[0]].push_back(v[1]);
    }
    
    for (auto& kv: graph) {
        sort(kv.second.begin(), kv.second.end());
    }
    
    vector<string> path;
    path.push_back("ICN");
    backtrack("ICN", graph, path, tickets.size());
    
    return path;
}