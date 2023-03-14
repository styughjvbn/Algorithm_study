import sys
from collections import deque
input=sys.stdin.readline

#DSLR 연산
def D(n):
    return (n*2)%10000
def S(n):
    if n==0:
        return 9999
    else:
        return n-1
def L(n):
    str_n=str(n+10000)
    temp=str_n[2:]+str_n[1]
    return int(temp)
def R(n):
    str_n = str(n + 10000)
    temp = str_n[-1]+str_n[1:4]
    return int(temp)

T=int(input())
for _ in range(T):
    A,B=map(int,input().split())
    visit=[""]*10000
    queue=deque()
    queue.append(A)
    visit[A]="1"
    while queue:
        num=queue.popleft()
        if num==B:
            break
        num1=D(num)
        if visit[num1]=="":
            visit[num1]=visit[num]+"D"
            queue.append(num1)
        num1 = S(num)
        if visit[num1] == "":
            visit[num1] = visit[num] + "S"
            queue.append(num1)
        num1 = L(num)
        if visit[num1] == "":
            visit[num1] = visit[num] + "L"
            queue.append(num1)
        num1 = R(num)
        if visit[num1] == "":
            visit[num1] = visit[num] + "R"
            queue.append(num1)
    print(visit[B][1:])
