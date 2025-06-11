import sys

input = sys.stdin.readline

n,t = map(int, input().split())
subjects = [list(map(int,input().split())) for _ in range(n)]
subjects.sort(key = lambda a:a[0])

dp = [0 for _ in range(t+1)]

for subject in subjects:
    for i in range(t, subject[0]-1, -1):
        dp[i] = max(dp[i], subject[1] + dp[i-subject[0]])
        # print(dp)
print(dp[t])