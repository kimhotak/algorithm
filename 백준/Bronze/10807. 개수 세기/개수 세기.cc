#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, k[n], v;
	cin >> n;
	for (int i=0; i<n; i++) {
		cin >> k[i];
	}

	cin >> v;
	int cnt = 0;
	for (int i=0; i<n; i++) {
		if (k[i] == v) cnt += 1; 
	}

	cout << cnt;
	return 0;
}