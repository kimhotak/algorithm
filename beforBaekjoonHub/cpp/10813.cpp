#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m;
	cin >> n >> m;
	vector<int> basket(n,0);
	for (int idx=0; idx<n; idx++) {
		basket[idx] = idx+1;
	}
	
	
	for (int idx=0; idx<m; idx++) {
		int i, j, temp;
		cin >> i >> j;
		temp = basket[--i];
		basket[i] = basket[--j];
		basket[j] = temp;
	}

	for (int idx=0; idx<n; idx++) {
		cout << basket[idx] << ' ';
	}
	return 0;
}