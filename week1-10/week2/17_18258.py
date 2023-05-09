import sys

n=int(sys.stdin.readline().strip())

queue=[0]*(n+1)
front=0
back=0

for i in range(n):
    oper=sys.stdin.readline().split()
    if oper[0]=='push':
        queue[back]=oper[1]
        back+=1
    elif oper[0]=='pop':
        if back==front:
            print(-1)
        else:
            print(queue[front])
            front+=1
    elif oper[0]=='size':
        print(back-front)
    elif oper[0] == 'empty':
        if back==front:
            print(1)
        else:
            print(0)
    elif oper[0] == 'front':
        if back == front:
            print(-1)
        else:
            print(queue[front])
    elif oper[0] == 'back':
        if back == front:
            print(-1)
        else:
            print(queue[back-1])