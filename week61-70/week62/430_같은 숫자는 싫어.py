def solution(arr):
    answer=[]
    arr.reverse()
    while arr:
        num=arr.pop()
        if len(answer)==0 or answer[-1]!=num:
            answer.append(num)

    return answer