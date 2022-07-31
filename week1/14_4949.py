import sys
#스택과 조건문을 이용한 단순한 문제..
stack=[]
flag=0
while True:
    string=sys.stdin.readline()
    if string==".\n":
        break
    else:
        string = string.strip()
        for j in string:
            if j=='(' or j=='[':
                stack.append(j)
            elif j==')' or j==']':
                if len(stack)<1:
                    print('no')
                    stack.clear()
                    flag = 1
                    break
                else:
                    if j==')':
                        if(stack.pop()!='('):
                            print('no')
                            stack.clear()
                            flag = 1
                            break
                    else:
                        if (stack.pop() != '['):
                            print('no')
                            stack.clear()
                            flag = 1
                            break

        if flag==1:
            flag=0
            continue
        else:
            if len(stack)>0:
                print('no')
                stack.clear()
            else:
                print('yes')


