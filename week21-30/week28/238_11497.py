import sys
from collections import deque
input=sys.stdin.readline

K=int(input())
for _ in range(K):
    N=int(input())
    logs=list(map(int,input().split()))
    logs.sort(reverse=True)
    min_lv=logs[0]-logs[1]
    for i in range(N-2):
        min_lv=max(min_lv,logs[i]-logs[i+2])
    min_lv=max(min_lv,logs[-2]-logs[-1])
    print(min_lv)

