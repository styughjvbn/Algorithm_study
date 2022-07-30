import sys

n=int(sys.stdin.readline().strip())

arr=list(map(int,sys.stdin.readline().split()))
#정렬후 누적합을 모두 더한다.
arr.sort()
arr=[0]+arr
num=0;
for i in range(n):
    arr[i+1]=arr[i]+arr[i+1]
    num+=arr[i+1]
print(num)
