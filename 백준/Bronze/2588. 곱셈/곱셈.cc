#include <iostream>
using namespace std;

int main() {
	// 코드 작성
	int a, b;
	int c, d, e, f;
	cin >> a >> b;
	c = a * (b % 10);
	d = a * (b % 100 / 10);
	e = a * (b / 100);
	f = a * b;
	cout << c << endl
		 << d << endl
		 << e << endl
		 << f << endl;
	return 0;
}