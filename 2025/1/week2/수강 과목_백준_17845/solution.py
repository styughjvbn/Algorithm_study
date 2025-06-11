import sys

input = sys.stdin.readline

n,k = map(int,input().split())
subjects = []
for _ in range(k):
    subjects.append(list(map(int,input().split())))

dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
for i in range(n+1):
    for j in range(1,k+1):
        tempMaxImportance = 0
        if i - subjects[j-1][1]>=0:
            tempMaxImportance = dp[i-subjects[j-1][1]][j-1]+subjects[j-1][0]
        dp[i][j] = max(dp[i][j-1], tempMaxImportance)
print(dp[n][k])