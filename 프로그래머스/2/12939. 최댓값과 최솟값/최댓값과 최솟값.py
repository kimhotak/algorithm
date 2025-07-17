def solution(s):
    answer = ''
    return f'{min(int(i)for i in s.split())} {max(int(i)for i in s.split())}'