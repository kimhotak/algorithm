#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());

    set<int> res;

    if (n % 2 == 0) {
        int left = 0, right = arr.size() - 1;
        int l = arr[left] + arr[right];
        bool flag = true;
        while (left < right) {
            if (arr[left++] + arr[right--] != l) {
                flag = false;
                break;
            }
        }
        if (flag) res.insert(l);
    }

    int left = 0;
    int right = lower_bound(arr.begin(), arr.end(), arr[arr.size() - 1]) - arr.begin() -1;
    if ((right - left+1) % 2 == 0) {
        int l = arr[n - 1];
        bool flag = true;
        while (left < right) {
            if (arr[left++] + arr[right--] != l) {
                flag = false;
                break;
            }
        }
        if (flag) res.insert(l);
    }


    for (int i : res) cout << i << ' ';

    return 0;
}