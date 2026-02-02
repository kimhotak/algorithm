#include <string>
#include <vector>

using namespace std;

string solution(string code) {
    string answer = "";
    bool mode = 0;
    for (int i = 0; i < code.length(); i++) {
        if (mode == 0) {
            if (code[i] != '1' && !(i&1)) answer += code[i];
            if (code[i] == '1') mode = 1;
        }
        else {
            if (code[i] != '1' && i&1) answer += code[i];
            if (code[i] == '1') mode = 0;
        }
    }
    
    return answer.empty() ? "EMPTY" : answer;
}