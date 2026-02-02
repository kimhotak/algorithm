#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<int> arr(n+1);
    for (int i = 1; i <= n; i++) cin >> arr[i];


    vector<int> dp(n + 1);
	dp[0] = 0;
    dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
    for (int i = 3; i <= n; i++) {
        dp[i] = max(dp[i - 1], arr[i] + dp[i - 2]);
        dp[i] = max(dp[i], arr[i] + arr[i - 1] + dp[i - 3]);
    }

    cout << dp[n];

    return 0;
}