#include<iostream>
#include<cmath>
using namespace std;

int main() {
    int n, m;
    cin >> m >> n;

    int sum = 0;
    int min = 0;
    for (int i = 1; i <= sqrt(n); i++) {
        if (i >= sqrt(m)) {
            sum += i*i;
            if (min == 0) min = i*i;
        }
    }

    if (sum == 0) cout << -1;
    else cout << sum << endl << min;
    return 0;
}