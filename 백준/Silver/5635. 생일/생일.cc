#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    string old_name = "asdf", young_name;
    int old_date = INT32_MAX, young_date = 0;
    for (int i = 0; i < n; i++) {
        string name;
        int date, tmp;
        cin >> name >> date >> tmp;
        date += tmp * 100;
        cin >> tmp;
        date += tmp * 10000;
        if (old_date > date) {
            old_date = date;
            old_name = name;
        }
        if (young_date < date) {
            young_date = date;
            young_name = name;
        }
    }

    cout << young_name << '\n' << old_name;

    return 0;
}