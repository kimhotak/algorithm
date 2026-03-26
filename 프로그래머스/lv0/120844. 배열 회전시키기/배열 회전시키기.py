def solution(numbers, direction):
    return [numbers[(i + (-1 if direction=='right' else 1))%len(numbers)]  for i in range(len(numbers))]