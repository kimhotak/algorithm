#include <iostream>
using namespace std;

int main() {
	string str;
	cin >> str;
	for (int i=0; i<=25; i++) {
		int temp = str.find('a' + i);
		cout << temp << ' ';
	}
	return 0;
}