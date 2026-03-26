#include<bits/stdc++.h>

using namespace std;

static vector<vector<int>> tree;
static vector<int> iswolf;
static int maxsheep;

void dfs(int node, int sheep, int wolf, vector<int> nextnodes) {
    if (iswolf[node]) wolf++;
    else sheep++;
    
    if (wolf >= sheep) return;
    
    maxsheep = max(maxsheep, sheep);
    
    for (int i = 0; i < nextnodes.size(); i++) {
        if (nextnodes[i] == node) nextnodes.erase(nextnodes.begin() + i);
    }
    
    vector<int> candidates = nextnodes;
    
    for (int i : tree[node]) {
        candidates.push_back(i);
    }
    
    for (int next: candidates) {
        dfs(next, sheep, wolf, candidates);
    }
}

int solution(vector<int> info, vector<vector<int>> edges) {
    tree.assign(info.size(), vector<int>());
    for (auto& e: edges) {
        tree[e[0]].push_back(e[1]);
    }
    iswolf = info;
    maxsheep = 0;
    
    dfs(0,0,0,vector<int>{0});
    
    return maxsheep;
}