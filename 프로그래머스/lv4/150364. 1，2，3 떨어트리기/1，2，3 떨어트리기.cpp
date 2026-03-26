#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<vector<int>> edges, vector<int> target) {
    int n = edges.size()+1; // 노드의 개수
    
    vector<vector<int>> tree(n, vector<int>());
    for (auto e: edges) tree[e[0]-1].push_back(e[1]-1);
    // 0-idx 맞춤 node 번호 0 ~ n-1
    
    for (int i = 0; i < n; i++) {
        sort(tree[i].begin(), tree[i].end()); // 숫자가 작은 노드부터
    }
    
    vector<int> road(n); // 길
    vector<int> count(n); // 리프에 들어간 횟수
    vector<int> droporder; // 떨어지는 공이 들어가는 리프 순서
    
    while (1) {
        int node = 0;
        while (tree[node].size() != 0) {
            int next = tree[node][road[node]];
            road[node] = (road[node] + 1) % tree[node].size();
            node = next;
        }
        count[node]++;
        droporder.push_back(node);
        
        if (count[node] > target[node]) return {-1};
        
        bool isend = true;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] * 3 < target[i]) isend = false;
        }
        if (isend) break;
    }
    
    vector<int> ans;
    for (int leaf : droporder) {
        count[leaf]--;
        
        
        for (int val = 1; val <= 3; val++) {
            if (target[leaf] - val <= count[leaf] * 3) {
                ans.push_back(val);
                target[leaf] -= val;
                break;
            }
        }
    }
    
    return ans;
}