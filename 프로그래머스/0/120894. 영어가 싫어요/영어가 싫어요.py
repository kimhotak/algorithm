def solution(numbers):
    answer = 0
    l = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    for idx, item in enumerate(l):
        numbers=numbers.replace(item,str(idx))
    return int(numbers)