import sys

n,m=map(int,sys.stdin.readline().split())

arr1=list(map(int,sys.stdin.readline().split()))

low=1
high=max(arr1)
mid=(low+high)//2
tree=0
while low<=high:
    mid=(low+high)//2
    for i in arr1:
        temp=i-mid
        if temp>=0:
            tree+=temp
    if tree<m:
        high=mid-1
    elif tree>=m:
        low=mid+1
    tree=0

print(high)