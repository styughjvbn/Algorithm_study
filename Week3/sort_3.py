import sys

n = int(sys.stdin.readline().strip())

arr=[0]*10001

for i in range(n):
    arr[int(sys.stdin.readline().strip())]+=1

for i in range(10001):
    for j in range(arr[i]):
        print(i)