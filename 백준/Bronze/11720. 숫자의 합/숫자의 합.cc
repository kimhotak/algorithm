#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, sum = 0;
	cin >> n;
	while (n--) {
		char c;
		cin >> c;
		sum += int(c) - int('0');
	}
	cout << sum;
	return 0;
}