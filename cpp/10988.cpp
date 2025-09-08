#include <iostream>
using namespace std;

int main() {
	string word;
	cin >> word;
	int r, l;
	l = 0;
	r = word.length() -1;
	int is_pal = 1;
	while (r > l){
		if (word[r] != word[l]){
			is_pal = 0;
		}
		r--;
		l++;
	}
	cout << is_pal;
	return 0;
}