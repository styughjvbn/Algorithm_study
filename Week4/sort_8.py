import sys
from operator import itemgetter

n = int(sys.stdin.readline().strip())

arr=[0]*n

for i in range(n):
    arr[i]=((sys.stdin.readline().strip()))
arr=list(set(arr))
arr.sort()
arr.sort(key=len)
for i in range(len(arr)):
    print(arr[i])