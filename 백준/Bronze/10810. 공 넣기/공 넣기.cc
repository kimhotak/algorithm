#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m;
	cin >> n >> m;
	vector<int> baskit(n);

	int i, j, k;
	while (cin >> i >> j >> k) {
		for (;i<=j;i++) {
			baskit[i-1] = k;
		}
	}

	for (int i=0; i<n; i++) {
		cout << baskit[i] << ' ';
	}
	return 0;
}