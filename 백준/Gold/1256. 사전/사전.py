import sys
input = sys.stdin.readline
n, m, k = map(int,input().split())

dp = [[1] * (m + 1) for _ in range(n + 1)]

for a in range(1, n + 1):
    for z in range(1, m + 1):
        dp[a][z] = dp[a-1][z] + dp[a][z-1]

if k > dp[n][m]:
    print(-1)
    exit()

answer = ""

while n > 0 and m > 0:

    if k <= dp[n-1][m]:
        n -= 1
        answer += 'a'

    else:
        k -= dp[n-1][m]
        m -= 1
        answer += 'z'

print(answer + ('a' * n) + ('z' * m))


'''
3A3Z {
    2A3Z {
        1A3Z {
            a a azzz
            a a zazz
            a a zzaz
            a a zzza 
        }
        2A2Z {
            1A2Z {
                a z a azz
                a z a zaz
                a z a zza 
            }
            2A1Z {
                a z z aaz
                a z z aza
                a z z zaa 
            }
        }
    }
    3A2Z{
        2A2Z{
            1A2Z{
                z a a azz
                z a a zaz
                z a a zza
            }
            2A1Z{
                z a z aaz
                z a z aza
                z a z zaa
            }
        }
        3A1Z{
            z z aaaz
            z z aaza
            z z azaa
            z z zaaa
        }
    }
}
'''