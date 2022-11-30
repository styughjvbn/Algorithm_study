import sys

input=sys.stdin.readline
stack=[]

in_str=input().strip()
bomb=input().strip()

for i in range(len(in_str)):
    stack.append(in_str[i])
    if in_str[i]== bomb[-1]:
        temp=stack[-len(bomb):]
        if len(temp)!=len(bomb):
            continue
        else:
            flag=True
            for j in range(len(temp)):
                if temp[j]!=bomb[j]:
                    flag=False
                    break
            if flag:
                for j in range(len(bomb)):
                    stack.pop()

if len(stack):
    print("".join(stack))
else:
    print("FRULA")