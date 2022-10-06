import sys

paper=[[0 for _ in range(100)]for _ in range(100)]

n=int(sys.stdin.readline())
for i in range(n):
    x,y=map(int,sys.stdin.readline().split())
    for j in range(x,x+10):
        for k in range(y,y+10):
            paper[k][j]=1
sum=0
for i in range(100):
    for j in range(100):
        if paper[i][j]==1:
            sum+=1

print(sum)