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
#include <numeric>
#include <sstream>
#include <queue>
#include <stack>
#include <deque>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string str, tmp;
    while (getline(cin, tmp)) str += tmp;
    stringstream ss(str);
    char c;
    int sum, num;
    ss >> sum;
    while (ss >> c >> num) sum += num;
    cout << sum;


    return 0;
}
