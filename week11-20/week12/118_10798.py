import sys

temp=[[0for _ in range(15)]for _ in range(5)]
for i in range(5):
    tmp=sys.stdin.readline().strip()
    for j in range(len(tmp)):
        temp[i][j]=tmp[j]
for i in range(15):
    for j in range(5):
        if temp[j][i]!=0:
            print(temp[j][i],end="")