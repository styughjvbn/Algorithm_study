import sys

n,c=map(int,sys.stdin.readline().split())
#집과 집 사이의 간격이 x이상이여야 할때 c개의 공유기를 모두 설치할수 있는지 확인한다.
#x의 수를 이분탐색으로 찾아낸다.
arr=[0]*n
for i in range(n):
    arr[i]=int(sys.stdin.readline().strip())

arr.sort()

low=1
high=arr[-1]-arr[0]
count=1
result=0
while low<=high:
    mid=(low+high)//2
    temp=arr[0]
    for i in range(1,n):
        if temp+mid<=arr[i]:
            count+=1
            temp = arr[i]
    if count>=c:
        low=mid+1
        result=mid
    else:
        high=mid-1
    count=1

print(result)
