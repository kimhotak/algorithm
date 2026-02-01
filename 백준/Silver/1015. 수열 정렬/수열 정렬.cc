#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

string solve();

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    //freopen("input.txt", "r", stdin);

    int n;
    cin >> n;
    vector<pair<int, int>> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i].first;
        arr[i].second = i;
    }
    sort(arr.begin(), arr.end());
    
    vector<int> ans(n);
    for (int i = 0; i < n; i++) {
		ans[arr[i].second] = i;
    }

    for (int i : ans) cout << i << " ";

    return 0;
}
