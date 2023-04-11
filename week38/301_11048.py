import sys

input=sys.stdin.readline

n,m=map(int,input().split())
mage=[[0 for i in range(m+1)]]
for i in range(n):
    line=list(map(int,input().split()))
    mage.append([0]+line)

for i in range(1,n+1):
    for j in range(1,m+1):
        mage[i][j]+=max(mage[i-1][j],mage[i][j-1],mage[i-1][j-1])
print(mage[n][m])