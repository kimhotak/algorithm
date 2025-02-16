#include <iostream>
using namespace std;

int main() {
	int x, n;
	cin >> x >> n;

	int a, b;
	int s = 0;
	for (int i=0; i<n; i++) {
		cin >> a >> b;
		s += a * b;
	}

	if (s == x) cout << "Yes";
	else cout << "No";
	return 0;
}