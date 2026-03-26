#include<bits/stdc++.h>
using namespace std;

int solution(string s)
{
    int idx = 0;
    stack<int> st;
    while (idx < s.size()) {
        if (!st.empty() && s[idx] == st.top()) {
            st.pop();
            idx++;
        }
        else {
            st.push(s[idx++]);
        }
    }

    return st.empty() ? 1 : 0;
}