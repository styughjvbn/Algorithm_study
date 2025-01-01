import sys

n=int(sys.stdin.readline().strip())
arr=list(map(int,sys.stdin.readline().split()))
result=[-1 for _ in range(n)]
stack=[]
#숫자를 차례대로 스택에 넣으면서 넣는 숫자보다 작은 숫자가 스택에 있다면 작은 숫자를 뺀다.
for i in range(n):
    if len(stack)<1:
        stack.append(i)
    else:
        while True:
            if arr[i]>arr[stack[len(stack)-1]]:
                result[stack.pop()]=arr[i]
            else:
                stack.append(i)
                break
            if len(stack)<1:
                stack.append(i)
                break

print(' '.join(map(str,result)))
