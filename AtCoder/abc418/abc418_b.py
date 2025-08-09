s = input()
ss = [i for i in range(len(s)) if s[i]=='t']
res = 0
for i in range(len(ss)):
    for j in range(len(ss)):
        t_ = ss[j] - ss[i] + 1
        if t_ < 3:
            continue
        x = j - i + 1
        res = max(res, (x - 2)/(t_ - 2))
print(res)