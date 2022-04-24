import sys
import statistics

n = int(sys.stdin.readline().strip())

arr=[0]*n

for i in range(n):
    arr[i]=(int(sys.stdin.readline().strip()))

arr.sort()
mean=statistics.mean(arr)

median=statistics.median(arr)
mode=statistics.multimode(arr)
if(len(mode)>1):
    mode=mode[1]
else:
    mode=mode[0]
range=arr[len(arr)-1]-arr[0]
print(round(mean))
print(median)
print(mode)
print(range)