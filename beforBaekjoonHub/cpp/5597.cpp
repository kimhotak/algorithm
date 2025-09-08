#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	vector<bool> hw(30,true);
	for (int i=0; i<28; i++) {
		int hwed;
		cin >> hwed;
		hw[hwed-1] = false;
	}
	for (int i=0; i<30; i++) {
		if (hw[i]) {
			cout << i+1 << '\n';
		}
	}
	return 0;
}