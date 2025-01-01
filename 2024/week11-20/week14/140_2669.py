import sys

paper=[[0 for _ in range(100)]for _ in range(100)]

for i in range(4):
    x1,y1,x2,y2=map(int,sys.stdin.readline().split())
    for j in range(x1-1,x2-1):
        for k in range(y1-1,y2-1):
            paper[k][j]=1

result=0
for i in range(100):
    for j in range(100):
        if paper[i][j]==1:
            result+=1

print(result)