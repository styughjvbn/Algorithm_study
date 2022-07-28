import sys

n,m=list(map(int,sys.stdin.readline().split()))

arr=[[] for _ in range(n)]

for i in range(n):
    arr[i]=[0]+list(map(int,sys.stdin.readline().split()))

#2차원 배열의 행별로 누적합을 구해준다.
for j in range(n):
    for k in range(n):
        arr[j][k+1]=arr[j][k]+arr[j][k+1]

#범위내에 있는 행들의 구간합을 누적합을 통해 구하고 sum변수에 모두 더해준 후에 sum을 출력한다.
for k in range(m):
    x1,y1,x2,y2=(map(int,sys.stdin.readline().split()))
    sum=0
    for p in range(x1,x2+1):
        sum+=(arr[p-1][y2]-arr[p-1][y1-1])
    print(sum)