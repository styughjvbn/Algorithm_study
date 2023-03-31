import sys

input=sys.stdin.readline

n=int(input())
card1=list(map(int,input().split()))
m=int(input())
card2=list(map(int,input().split()))
card1.sort()

for i in range(m):
    min=0
    max=n-1
    mid=(max+min)//2
    flag=False
    while min<=max:

        if card1[mid]>card2[i]:
            max=mid-1
            mid=(max+min)//2
        elif card1[mid]<card2[i]:
            min=mid+1
            mid = (max + min) // 2
        else:
            flag=True
            break
    if flag:
        print(1,end=" ")
    else:
        print(0,end=" ")
