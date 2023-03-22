import sys
input=sys.stdin.readline

N,L=map(int,input().split())
fruit=list(map(int,input().split()))
fruit.sort()
for i in range(N):
    if L>=fruit[i]:
        L+=1
    else:
        break
print(L)