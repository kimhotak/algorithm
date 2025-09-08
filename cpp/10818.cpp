#include <iostream>
#include <vector>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	int max = -1000000;
	int min = 1000000;
	cin >> n;
	vector<int> v(n);
	for (int i=0; i<n; i++) {
		cin >> v[i];
		if (v[i] < min) min = v[i];
		if (v[i] > max) max = v[i];
	}
	cout << min << ' ' << max;
	return 0;
}