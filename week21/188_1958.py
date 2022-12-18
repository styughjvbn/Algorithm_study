import sys

input=sys.stdin.readline

str1=[""]+list(input().strip())
str2=[""]+list(input().strip())
str3=[""]+list(input().strip())


dp=[[[0 for _ in range(len(str3))] for _ in range(len(str2))] for _ in range(len(str1))]

for i in range(1,len(str1)):
    for j in range(1,len(str2)):
        for k in range(1,len(str3)):
            if str1[i]==str2[j] and str1[i]==str3[k]:
                dp[i][j][k]=dp[i-1][j-1][k-1]+1
            else:

                dp[i][j][k]=max([dp[i][j][k-1],dp[i][j-1][k],dp[i-1][j][k],dp[i-1][j][k-1],dp[i-1][j-1][k]])

print(dp[-1][-1][-1])
