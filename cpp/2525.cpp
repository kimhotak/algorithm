#include <iostream>
using namespace std;

int main() {
	int hour, min;
	int need_time;
	cin >> hour >> min >> need_time;
	min += need_time;
	if (min >= 60) {
		hour += min / 60;
		min = min % 60;
		hour = hour % 24;
	}
	cout << hour << ' ' << min;
	return 0;
}