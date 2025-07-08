def solution(sequence):
    n = len(sequence)
    dp = [0] * (n + 1) # 1을 먼저 곱하는 경우
    dp_ = [0] * (n + 1) # -1을 먼저 곱하는 경우
    for i in range(n):
        if i%2: # 홀수
            seq = -sequence[i]
            seq_ = sequence[i]
        else: # 짝수
            seq = sequence[i]
            seq_ = -sequence[i]
            
        if dp[i] + seq < 0:
            dp[i+1] = 0
        else:
            dp[i+1] = dp[i] + seq
            
        if dp_[i] + seq_ < 0:
            dp_[i+1] = 0
        else:
            dp_[i+1] = dp_[i] + seq_
    
    answer = max(max(dp),max(dp_))
    return answer