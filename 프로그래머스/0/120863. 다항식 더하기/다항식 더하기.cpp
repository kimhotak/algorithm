#include<bits/stdc++.h>

using namespace std;

string solution(string polynomial) {
    stringstream ss(polynomial);
    int x = 0, n = 0;
    string str;
    while (ss >> str) {
        if (str == "+") continue;
        else if (str.find("x") == string::npos) {
            n += stoi(str);
        }
        else {
            if (str.size() == 1) x++;
            else x += stoi(str.substr(0,str.size()-1));
        }
        
    }
    string answer = "";
    if (x > 1) answer += to_string(x);
    if (x > 0) answer += "x";
    if (x > 0 && n > 0) answer += " + ";
    if (n > 0) answer += to_string(n);
    return answer;
}