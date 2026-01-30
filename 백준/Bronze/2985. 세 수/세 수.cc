#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <algorithm>
#include <iomanip>
#include <climits>
#include <utility>
#include <cmath>
#include <sstream>
#include <queue>
#include <stack>
#include <deque>
#include <bitset>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b, c;
    cin >> a >> b >> c;
    if (a + b == c) cout << a << '+' << b << '=' << c;
    else if (a + b == c) cout << a << '+' << b << '=' << c;
    else if (a - b == c) cout << a << '-' << b << '=' << c;
    else if (a / b == c) cout << a << '/' << b << '=' << c;
    else if (a * b == c) cout << a << '*' << b << '=' << c;

    else if (a == b + c) cout << a << '=' << b << '+' << c;
    else if (a == b - c) cout << a << '=' << b << '-' << c;
    else if (a == b / c) cout << a << '=' << b << '/' << c;
    else if (a == b * c) cout << a << '=' << b << '*' << c;
    
    return 0;
}
