import sys
#up down 게임과 비슷한 맥락으로 반씩 줄여나가면서 확인한다.
k,n=map(int,sys.stdin.readline().split())

arr1=[0]*k
for j in range(k):
    arr1[j] = int(sys.stdin.readline().strip())


low=1
high=max(arr1)
base=(low+high)//2
count=0

while low<=high:
    base = (low + high) // 2
    for i in arr1:
        count+=i//base
    if count>=n:
        low=base+1
    else:
        high=base-1
    count=0

print(high)

