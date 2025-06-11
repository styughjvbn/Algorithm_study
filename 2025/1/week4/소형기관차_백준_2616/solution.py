import sys

input = sys.stdin.readline

n = int(input())
trainNum = list(map(int,input().split()))
s = int(input())
prefix = [0, trainNum[0]]
for i in range(1, n):
    prefix.append(prefix[-1]+trainNum[i])
# print(prefix)
trainSets = []
for i in range(s, n+1):
    trainSets.append(prefix[i]-prefix[i-s])
dp = [[0 for _ in range(len(trainSets))] for _ in range(4)]
for i in range(1,4):
    for j in range(len(trainSets)):
        tempNum = trainSets[j]
        if j - s >= 0:
            tempNum+=dp[i-1][j-s]
        prevNum = 0
        if j>=1:
            prevNum = dp[i][j-1]
        dp[i][j] = max(tempNum, prevNum)
# print(dp)
print(dp[3][len(trainSets)-1])