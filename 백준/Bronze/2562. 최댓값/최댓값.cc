#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	vector<int> num(9);
	int max = 0;
	int idx;
	for (int i=0; i<9; i++) {
		cin >> num[i];
		if (max < num[i]) {
			max = num[i];
			idx = i+1;
		} 
	}
	cout << max << '\n' << idx;
	return 0;
}