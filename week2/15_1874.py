import sys
#단순한 스택문제..
n=int(sys.stdin.readline().strip())

stack=[]
foo=1
result=''
flag=0
for i in range(n):
    num=int(sys.stdin.readline().strip())
    while True:
        flag+=1
        if len(stack)<1:
            stack.append(foo)
            result += '+'
            foo += 1
        else:
            if(stack[len(stack)-1]!=num):
                if flag>n*2:
                    print('NO')
                    exit()
                stack.append(foo)
                result+='+'
                foo+=1
            elif stack[len(stack)-1]==num:
                stack.pop()
                result+='-'
                break

if len(stack)>1:
    print('NO')
else:
    print('\n'.join(result))