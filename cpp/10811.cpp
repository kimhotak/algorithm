#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n , m;
	cin >> n >> m;
	vector<int> basket(n);
	for (int i=0; i<n; i++) {
		basket[i] = i+1;
	}
	
	for (int i=0; i<m; i++) {
		int j, k;
		cin >> j >> k;
		reverse(basket.begin() + j - 1, basket.begin() + k);
	}

	for (int i=0; i<n; i++) {
		cout << basket[i] << ' ';
	}
	return 0;
}