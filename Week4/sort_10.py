import sys

n = int(sys.stdin.readline().strip())
a=0
def makelist(num):
    global a
    a=a+1
    return [int(num),a]

arr=list(map(makelist,sys.stdin.readline().strip().split()))
arr.sort(key=lambda q:q[0])
b=0
prevnum=arr[0][0]
arr[0][0]=0
for i in range(1,len(arr)):
    if(arr[i][0]==prevnum):
        prevnum=arr[i][0]
        arr[i][0]=b
    else:
        b=b+1
        prevnum = arr[i][0]
        arr[i][0]=b
arr.sort(key=lambda q:q[1])
print(" ".join(str(s[0]) for s in arr))