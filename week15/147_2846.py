import sys

n=int(sys.stdin.readline())

arr=list(map(int,sys.stdin.readline().split()))

base=arr[0]
max_height=0
for i in range(1,n):
    if arr[i]>arr[i-1]:
        pass
    else:
        max_height=max(arr[i-1]-base,max_height)
        base=arr[i]
max_height=max(arr[-1]-base,max_height)
print(max_height)