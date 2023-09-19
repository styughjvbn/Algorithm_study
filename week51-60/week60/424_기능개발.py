import math

def solution(progresses, speeds):
    answer = []
    stack=[]
    days=0
    for i in zip(progresses,speeds):
        stack.append(math.ceil((100-i[0])/i[1]))
    max_day=stack[0]
    count=0
    for i in stack:
        if i<=max_day:
            count+=1
        else:
            max_day=i
            answer.append(count)
            count=1
    if count:
        answer.append(count)
    return answer