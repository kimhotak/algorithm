#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string word;
	int i;
	cin >> word >> i;
	cout << word[i-1];
	return 0;
}