import sys

input=sys.stdin.readline

N=int(input())
cards=list(map(int,input().split()))
dp=[[0 for _ in range(len(cards)+1)]for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,len(cards)+1):
        if i-j>=0:
            dp[i][j]=max(dp[i-j][len(cards)]+cards[j-1],dp[i][j-1])
        else:
            dp[i][j] = dp[i][j - 1]
print(dp[N][len(cards)])