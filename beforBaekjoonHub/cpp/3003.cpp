#include <iostream>
using namespace std;

int main() {
	int pfect_set[6] = {1, 1, 2, 2, 2, 8};
	for (int i=0; i<6; i++) {
		int num;
		cin >> num;
		cout << pfect_set[i] - num << (i==5 ? '\n' : ' ');
	}
	return 0;
}