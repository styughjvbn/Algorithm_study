import sys

N,B=map(int,sys.stdin.readline().split())
result=[]
while N>0:
    if N%B>=10:
        result.append(chr(N%B+55))
    else:
        result.append(str(N%B))
    N=N//B
result.reverse()

print("".join(result))