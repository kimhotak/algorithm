#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int dice[3], price;
	int count = 0;
	cin >> dice[0] >> dice[1] >> dice[2];
	
	sort(dice, dice+3);

	for(int i=0;i<3;i++){
		if (dice[i] == dice[(i+1)%3]) count += 1;
	}

	switch (count)
	{
	case 3:
		price = 10000 + 1000 * dice[0];
		break;
	case 1:
		price = 1000 + 100 * dice[1];
		break;
	default:
		price = 100 * dice[2];
		break;
	}

	cout << price;

	return 0;
}