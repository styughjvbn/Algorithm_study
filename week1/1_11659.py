import sys

[n,m]=map(int,sys.stdin.readline().split())
arr=list(map(int,sys.stdin.readline().split()))
arr=[0]+arr
area=[[]]*m
for i in range(m):
    area[i]=list(map(int,sys.stdin.readline().split()))

#누적합 구하기
for k in range(1,n+1):
    arr[k]=arr[k-1]+arr[k]

#i~j번째 수까지의 합은 j번째 누적합에서 i-1번째 누적합을 빼면 가능하다.
for j in range(m):
    print(arr[area[j][1]]-arr[area[j][0]-1])
