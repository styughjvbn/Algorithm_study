import sys

input=sys.stdin.readline

str1=[""]+list(input().strip())
str2=[""]+list(input().strip())

LCS=[["" for _ in range(len(str2))] for _ in range(len(str1))]

dp=[[0 for _ in range(len(str2))] for _ in range(len(str1))]

for i in range(1,len(str1)):
    for j in range(1,len(str2)):
        if str1[i]==str2[j]:
            LCS[i][j]=LCS[i-1][j-1]+str1[i]
            dp[i][j]=dp[i-1][j-1]+1
        else:
            dp[i][j]=max([dp[i][j-1],dp[i-1][j]])
            if len(LCS[i][j - 1])>len(LCS[i - 1][j]):
                LCS[i][j] = LCS[i][j - 1]
            else:
                LCS[i][j] = LCS[i-1][j]


print(dp[-1][-1])
print(LCS[-1][-1])
