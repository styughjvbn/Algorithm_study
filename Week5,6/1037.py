import sys

num=int(sys.stdin.readline().strip())

arr=list(map(int,sys.stdin.readline().strip().split()))
arr.sort()
if(num%2==0):
    print(int(min(arr)*max(arr)))
else:
    print(arr[(len(arr))//2]**2)
