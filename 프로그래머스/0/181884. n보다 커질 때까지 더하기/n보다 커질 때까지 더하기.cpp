#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int n) {
    int idx = 0;
    int answer = 0;
    while (answer <= n) {
        answer = answer + numbers[idx++];
    };
    return answer;
}