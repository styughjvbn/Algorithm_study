import sys

#파이썬은 딕셔너리 자료구조를 이용하면 된다.
#이분탐색으로 할 필요가 전혀 없다.
n=int(sys.stdin.readline().strip())
arr1=list(map(int,sys.stdin.readline().split()))
m=int(sys.stdin.readline().strip())
arr2=list(map(int,sys.stdin.readline().split()))

arr3={}
prev=arr1[0]
count=1
for i in arr1:
    if i in arr3:
        arr3[i]+=1
    else:
        arr3[i]=1
for j in arr2:
    if j in arr3:
        print(arr3[j],end=' ')
    else:
        print(0,end=' ')