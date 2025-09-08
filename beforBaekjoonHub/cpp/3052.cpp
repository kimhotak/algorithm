#include <iostream>
#include <set>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	set<int> n;

	for (int i=0; i<10; i++) {
		int num;
		cin >> num;
		n.insert(num % 42);
	}
	cout << n.size();
	return 0;
}