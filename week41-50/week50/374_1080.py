import sys
input=sys.stdin.readline

n,m=map(int,input().split())

a=[list(map(int,list(input().strip()))) for _ in range(n)]
b=[list(map(int,list(input().strip()))) for _ in range(n)]

def calc(matrix,di,dj):
    for i in range(3):
        for j in range(3):
            matrix[i+di][j+dj]=(matrix[i+di][j+dj]+1)%2
    return matrix
result=0
for i in range(n-2):
    for j in range(m-2):
        if a[i][j]!=b[i][j]:
            a=calc(a,i,j)
            result +=1


for i in range(n):
    for j in range(m):
        if a[i][j] != b[i][j]:
            print(-1)
            exit()
print(result)
