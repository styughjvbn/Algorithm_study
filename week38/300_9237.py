import sys
input=sys.stdin.readline

n=int(input())
times=list(map(int,input().split()))
times.sort(reverse=True)

for i in range(1,n):
    times[i]+=i
print(max(times)+2)