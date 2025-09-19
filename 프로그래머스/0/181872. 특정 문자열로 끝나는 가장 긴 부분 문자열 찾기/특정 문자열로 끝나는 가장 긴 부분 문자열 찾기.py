def solution(myString, pat):
    return myString[:-len(pat)-myString[::-1].find(pat[::-1])]+pat