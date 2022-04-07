import sys
from operator import itemgetter


n = int(sys.stdin.readline().strip())
arr=[0]*n
for i in range(n):
    m,k=sys.stdin.readline().strip().split()
    arr[i]=[int(m),int(k)]

arr=sorted(arr,key=itemgetter(1,0))

for i in range(n):
    print(arr[i][0],arr[i][1])
