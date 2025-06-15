isbn = [int(i) if i.isdigit() else -1 for i in input()]
check_sum = isbn.pop()

lost_idx = isbn.index(-1)
lost_check_sum =