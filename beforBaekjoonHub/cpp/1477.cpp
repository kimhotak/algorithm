#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, m, l;
	cin >> n >> m >> l;
	vector<int> rest(n);
	for(int i = 0; i < n; ++i) cin >> rest[i];
	rest.push_back(l);
	sort(rest.begin(), rest.end());

	int left = 1, right = l + 1;
	while(left < right) {
		int mid = (left + right) / 2;
		int cnt = 0;
		int prev = 0;
		for(int i = 0; i < rest.size(); ++i) {
			int dist = rest[i] - prev;
			if(dist > mid) {
				// 직접 시뮬레이션 안하고 mid로 쪼개버림
				cnt += (dist - 1) / mid;
			}
			prev = rest[i];
		}
		if(cnt > m) {
			left = mid + 1;
		} else {
			right = mid;
		}
	}
	cout << left << endl;
	return 0;
}