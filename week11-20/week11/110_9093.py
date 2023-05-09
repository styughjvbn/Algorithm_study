import sys

n=int(sys.stdin.readline())

for _ in range(n):
    temp=list(sys.stdin.readline().split())
    for j in temp:
        for k in range(len(j)-1,-1,-1):
            print(j[k],end="")
        print(" ",end="")