import sys
#파이썬의 list자료형을 이용하여 스택 구현
n=int(sys.stdin.readline().strip())

stack=[]

for i in range(n):
    oper=int(sys.stdin.readline().strip())
    if(oper==0):
        stack.pop()
    else:
        stack.append(oper)

print(sum(stack))