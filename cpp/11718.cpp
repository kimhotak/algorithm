#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
    string line;
    while (getline(cin, line)) {
		cout << line << '\n';
    }
    return 0;
}