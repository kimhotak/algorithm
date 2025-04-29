#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	for (int i=1; i<=n; i++) {
		cout << string(n-i,' ');
		cout << string(i, '*') << '\n';
	}
	return 0;
}