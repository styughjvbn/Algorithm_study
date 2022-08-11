import sys

n,c=map(int,sys.stdin.readline().split())

arr=[0]*n
for i in range(n):
    arr[i]=int(sys.stdin.readline().strip())

arr.sort()

low=1
high=arr[-1]-arr[0]
count=0
while low<=high:
    mid=(low+high)//2
    temp=arr[0]
    for i in arr:
        temp+=mid
        if temp==i:
            count+=1
    if count>=c:
        low=mid+1
    else:
        high=mid-1
    count=0

print(low)
