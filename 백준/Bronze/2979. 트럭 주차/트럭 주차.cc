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
    vector<int> arr(1);
    for (int t = 0; t < 3; t++) {
        int i, o;
        cin >> i >> o;
        while (arr.size() < o) {
            arr.push_back(0);
        }
        for (int j = i; j < o; j++) {
            arr[j]++;
        }
    }
    
    int price = 0;
    for (int i : arr) {
        if (i == 1) price += a;
        else if (i == 2) price += 2*b;
        else if (i == 3) price += 3*c;
    }
    cout << price;


    return 0;
}
