import sys
#기본적인 이진탐색
n=int(sys.stdin.readline().strip())
arr1=list(map(int,sys.stdin.readline().split()))
m=int(sys.stdin.readline().strip())
arr2=list(map(int,sys.stdin.readline().split()))

arr1.sort()
def binary_search(arr,key):
    one=0
    last=len(arr)-1
    mid=(one+last)//2
    while(one<=last):
        if arr[mid]==key:
            return 1
        elif arr[mid]>key:
            last=mid-1
            mid=(one+last)//2
        elif arr[mid]<key:
            one=mid+1
            mid=(one+last)//2
    return 0
for i in arr2:
    print(binary_search(arr1,i))

