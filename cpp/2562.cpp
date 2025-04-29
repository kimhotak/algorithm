#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	vector<int> num(9);

	for (int i=0; i<9; i++) {
		cin >> num[i];
	}

	auto max_pos = max_element(num.begin(), num.end());
	int max_value = *max_pos;
	int idx = distance(num.begin(), max_pos) +1;
	

	cout << max_value << '\n' << idx;
	return 0;
}