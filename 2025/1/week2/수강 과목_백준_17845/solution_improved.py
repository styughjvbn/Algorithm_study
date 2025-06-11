import sys

input = sys.stdin.readline

n,k = map(int,input().split())
subjects = []
for _ in range(k):
    subjects.append(list(map(int,input().split())))

dp = [0 for _ in range(n+1)]
for i in range(k):
    for j in range(n, subjects[i][1]-1, -1):
        dp[j] = max(dp[j], dp[j-subjects[i][1]]+subjects[i][0])
print(max(dp))