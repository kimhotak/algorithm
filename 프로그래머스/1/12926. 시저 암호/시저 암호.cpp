#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    for (char c: s) {
        if (!isalpha(c)) answer += c;
        else if (islower(c)) answer += (c-'a'+n)%26 + 'a';
        else answer += (c-'A'+n)%26 + 'A';
    }
    return answer;
}