import copy
import sys
from collections import deque

input_string=sys.stdin.readline().strip()
stack_string=copy.deepcopy(input_string)
input_string=input_string.replace("()","2")
input_string=input_string.replace("[]","3")
stack=deque(stack_string[0])
tmp=""
if len(stack_string)==1:
    print(0)
    exit()
for i in range(1,len(stack_string)):
    if stack_string[i] == ')':
        if len(stack)>0 and stack[-1]=='(':
            stack.pop()
        else:
            print(0)
            exit()
    elif stack_string[i] == ']':
        if len(stack)>0 and stack[-1] == '[':
            stack.pop()
        else:
            print(0)
            exit()
    else:
        stack.append(stack_string[i])
for i in range(len(input_string)):
    if input_string[i]=='(':
        if i-1>=0 and (input_string[i-1]!='['and input_string[i-1]!='('):
            tmp+="+2*("
        else:
            tmp += "2*("
    elif input_string[i]=='[':
        if i - 1 >= 0 and (input_string[i - 1] != '[' and input_string[i - 1] != '('):
            tmp+="+3*("
        else:
            tmp += "3*("
    elif input_string[i]!=']'and input_string[i]!=')':
        if i - 1 >= 0 and (input_string[i - 1] == '2' or input_string[i - 1] == '3' or input_string[i - 1]==')'or input_string[i - 1]==']'):
            tmp += '+'+input_string[i]
        else:
            tmp += input_string[i]
    else:
        tmp+=')'

try:
    result=eval((tmp))
    if type(result)==tuple:
        print(0)
    else:
        print(result)
except:
    print(0)