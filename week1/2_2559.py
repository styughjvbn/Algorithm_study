import sys

[n,m]=map(int,sys.stdin.readline().split())
arr=list(map(int,sys.stdin.readline().split()))
arr=[0]+arr

#누적합을 구해둔다.
for i in range(n):
    arr[i+1]=arr[i]+arr[i+1]

#모든 구간합을 누적합을 이용해 구한다.
result_arr=[0]*(n-m+1)
for k in range(n-m+1):
    result_arr[k]=arr[k+m]-arr[k]

#가장 큰 구간합을 출력한다. 
print(max(result_arr))
