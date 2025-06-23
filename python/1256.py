import sys
input = sys.stdin.readline

n, m, k = map(int,input().split())
dp = [[1] * (n + 1) for _ in range(m + 1)]
for a in range(1, n + 1):
    for z in range(1, m + 1):
        dp[a][z]







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
a,z 중 한개가 1이 될떄까지 2개로 나누며 가는듯
dp의 느낌으로 하면 
'''