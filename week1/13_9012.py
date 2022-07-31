import sys
#스택과 조건문을 이용한 단순한 문제..
n=int(sys.stdin.readline().strip())

stack=[]
flag=0
for i in range(n):
    string=sys.stdin.readline().strip()

    for j in string:
        if(j=='('):
            stack.append(j)
        else:
            if len(stack)<1:
                print('NO')
                stack.clear()
                flag=1
                break
            else:
                stack.pop()
    if flag==1:
        flag=0
        continue
    else:
        if len(stack)>0:
            print('NO')
            stack.clear()
        else:
            print('YES')


