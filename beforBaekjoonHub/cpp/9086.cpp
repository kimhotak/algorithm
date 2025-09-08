#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	int t;
	cin >> t;
	
	while (t--) {
		string str;
		cin >> str;
		cout << str.front() << str.back() << '\n';
	}
	return 0;
}