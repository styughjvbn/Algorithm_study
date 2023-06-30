import sys

input=sys.stdin.readline

n,m=map(int,input().split())
board=[]
for i in range(n):
    board.append(list(input()))

result=64
for i in range(n-7):
    for j in range(m-7):
        base="W"
        count=0
        for k in range(8):
            for l in range(8):
                if board[i+k][j+l]!=base:
                    count+=1
                if base=="W":
                    base="B"
                else:
                    base="W"
            if base == "W":
                base = "B"
            else:
                base = "W"
        if count>32:
            count=64-count
        result=min(result,count)
print(result)
