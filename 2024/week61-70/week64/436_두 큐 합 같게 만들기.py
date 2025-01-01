from collections import deque

def solution(queue1, queue2):
    answer = 0
    queue1=deque(queue1)
    queue2=deque(queue2)
    sum1=sum(queue1)
    sum2=sum(queue2)
    for i in range(len(queue1)*3):
        if sum1>sum2:
            pop1=queue1.popleft()
            queue2.append(pop1)
            sum1-=pop1
            sum2+=pop1
        elif sum1<sum2:
            pop2=queue2.popleft()
            queue1.append(pop2)
            sum1+=pop2
            sum2-=pop2
        else:
            break
        answer+=1
    else:
        answer = -1


    return answer