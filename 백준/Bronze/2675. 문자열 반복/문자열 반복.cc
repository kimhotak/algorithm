#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int t;
	cin >> t;
	while (t--) {
		int r;
		string s;
		cin >> r >> s;
		for (char c : s) {
			for (int j=0; j<r; j++) {
				cout << c;
			}
		}
		cout << '\n';
	}
	return 0;
}