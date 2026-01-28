#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

	int sh, sm, ss, eh, em, es;
    char c;
    cin >> sh >> c >> sm >> c >> ss >> eh >> c >> em >> c >> es;;

    int h, m, s;
    s = es - ss;
	if (s < 0) {
        s += 60;
        em--;
    }
	m = em - sm;
    if (m < 0) {
        m += 60;
        eh--;
	}
    h = eh - sh;
	if (h < 0) {
        h += 24;
    }
    cout << setfill('0');

	cout << setw(2) << h << c << setw(2) << m << c << setw(2) << s;

    return 0;
}