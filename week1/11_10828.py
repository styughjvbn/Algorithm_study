import sys
#파이썬의 list자료형을 이용하여 스택 구현
n=int(sys.stdin.readline().strip())

stack=[]
for i in range(n):
    oper=sys.stdin.readline().split()
    if oper[0]=='push':
        stack.append(oper[1])
    elif oper[0]=='pop':
        if len(stack)>0:
            print(stack.pop())
        else:
            print(-1)
    elif oper[0]=='size':
        print(len(stack))
    elif oper[0]=='empty':
        if len(stack)>0:
            print(0)
        else:
            print(1)
    elif oper[0]=='top':
        if(len(stack))>0:
            print(stack[len(stack)-1])
        else:
            print(-1)