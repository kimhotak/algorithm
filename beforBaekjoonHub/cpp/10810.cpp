#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m;
	cin >> n >> m;
	vector<int> basket(n,0);

	int i, j, k;
	for (int idx=0; idx<m; idx++) {
		cin >> i >> j >> k;
		for (;i<=j;i++) {
			basket[i-1] = k;
		}
	}

	for (int idx=0; idx<n; idx++) {
		cout << basket[idx] << ' ';
	}
	return 0;
}