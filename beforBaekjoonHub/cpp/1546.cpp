#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	cin >> n;
	double m = 0, s = 0;

	for (int i=0; i<n; i++) {
		double score;
		cin >> score;
		m = max(score, m);
		s += score;
	}
	cout << (s * 100) / (m * n);

	return 0;
}