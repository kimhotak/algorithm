#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<int> arr(n);
    int m = 0;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        m = max(m, arr[i]);
    }

    vector<int> eachNum(m+1);
    for (int ai : arr) {
        eachNum[0]++;
        eachNum[ai]--;
    }

    vector<int> nums(m);
    int sum = eachNum[0];
    for (int i = 1; i <= m; i++) {
        nums[i - 1] = sum;
        sum += eachNum[i];
    }

    string res = "";
    int num = eachNum[0];
    for (int i = 0; i < m - 1; i++) {

        res = (char)(nums[i] % 10 + '0') + res;
        nums[i + 1] += nums[i] / 10;
    }
    res = to_string(nums[m - 1]) + res;

    cout << res;

    return 0;
}