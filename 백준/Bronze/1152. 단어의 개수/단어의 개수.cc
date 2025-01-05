#include <iostream>
#include <sstream>
using namespace std;

int main() {
	string line;
	getline(cin, line);

	stringstream ss(line);
	string word;
	int cnt = 0;

	while (ss >> word) {
		cnt++;
	}
	cout << cnt;
	return 0;
}