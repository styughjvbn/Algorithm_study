import sys
input=sys.stdin.readline

T=int(input())
for _ in range(T):
    N=int(input())
    value=list(map(int,input().split()))
    result=0
    base=value[-1]
    for i in range(N-2,-1,-1):
        if value[i]<base:
            result+=base-value[i]
        else:
            base=value[i]
    print(result)

