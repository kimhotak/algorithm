#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;
    while (n-- > 0) {
        int p, max = 0;
        cin >> p;
        string name = "a";
        for (int i = 0; i < p; i++) {
            int price;
            string tmp;
            cin >> price >> tmp;
            if (price > max) {
                max = price;
                name = tmp;
            }
        }
        cout << name << endl;

    }
    return 0;
}
