import sys
from collections import deque

n= int(sys.stdin.readline().strip())

my_deque=deque()
for i in range(n):
    oper=sys.stdin.readline().split()

    if oper[0]=='push_front':
        my_deque.appendleft(int(oper[1]))
    elif oper[0]=='push_back':
        my_deque.append(int(oper[1]))
    elif oper[0]=='pop_front':
        if len(my_deque)<1:
            print(-1)
        else:
            print(my_deque.popleft())

    elif oper[0]=='pop_back':
        if len(my_deque)<1:
            print(-1)
        else:
            print(my_deque.pop())

    elif oper[0]=='size':
        print(len(my_deque))
    elif oper[0]=='empty':
        if len(my_deque)<1:
            print(1)
        else:
            print(0)
    elif oper[0]=='front':
        if len(my_deque)<1:
            print(-1)
        else:
            print(my_deque[0])

    elif oper[0]=='back':
        if len(my_deque)<1:
            print(-1)
        else:
            print(my_deque[len(my_deque)-1])
