import sys

n,m=map(int,sys.stdin.readline().split())
square=[]
for i in range(n):
    square.append(list(sys.stdin.readline()))

result=1
for i in range(2,min(n,m)+1):
    for j in range((n-i)+1):
        for k in range(m-i+1):
            if square[j][k]==square[j+i-1][k] and square[j][k]==square[j][k+i-1] and square[j][k]==square[j+i-1][k+i-1]:
                result=max(result,i*i)

print(result)