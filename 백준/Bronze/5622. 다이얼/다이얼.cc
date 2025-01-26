#include <iostream>
using namespace std;

int main() {
	string gran;
	cin >> gran;
	int time = 0;
	for ( char g : gran ) {
		if ( g >= 'Z') g -= 1;
		if ( g >= 'S') g -= 1;
		time += (g - 'A') / 3 + 3;
	}
	cout << time;
	return 0;
}