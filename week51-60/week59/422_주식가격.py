def solution(prices):
    answer = [0 for _ in range(len(prices))]
    stack=[]

    for idx,price in enumerate(prices):
        if len(stack)==0:
            stack.append([price,idx])
            continue
        while stack and stack[-1][0]>price:
            temp=stack.pop()
            answer[temp[1]]=idx-temp[1]
        stack.append([price,idx])


    while stack:
        temp=stack.pop()
        answer[temp[1]]=len(prices)-1-temp[1]
    return answer