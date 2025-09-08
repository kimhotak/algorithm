#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int dice[3];
    cin >> dice[0] >> dice[1] >> dice[2];

    sort(dice, dice + 3);

    int price;
    if (dice[0] == dice[1] && dice[1] == dice[2]) {
        price = 10000 + 1000 * dice[0];
    } 
    else if (dice[0] == dice[1] || dice[1] == dice[2]) {
        price = 1000 + 100 * dice[1];
    } 
    else {
        price = 100 * dice[2];
    }

    cout << price;
    return 0;
}
