def solution(s):
    st = []
    for i in s.split(' '):
        if i != 'Z':
            st.append(int(i))
        else:
            st.pop()
                      
    answer = 0
    for i in st:
        answer += i
    return answer