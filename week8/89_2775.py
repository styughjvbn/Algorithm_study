import sys

t=int(sys.stdin.readline())
apart=[[0 for _ in range(15)]for _ in range(15)]
apart[0]=[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14]
for i in range(1,15):
    for j in range(15):
        apart[i][j]=apart[i-1][j]+apart[i][j-1]

for _ in range(t):

    k=int(sys.stdin.readline())
    n=int(sys.stdin.readline())
    print(apart[k][n])
