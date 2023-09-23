from functools import cmp_to_key

def solution(numbers):
    answer = ''
    numbers.sort(key=cmp_to_key(compare))

    numbers.reverse()
    answer=''.join(map(str,numbers))
    idx=-1
    for index,i in enumerate(answer):
        if i=="0":
            continue
        else:
            idx=index
            break
    else:
        idx=len(answer)-1
    if idx!=-1:
        answer=answer[idx:]
    return answer

def compare(a,b):
    str_a=str(a)
    str_b=str(b)
    if len(str_a)==len(str_b):
        return a-b
    c=int(str(a)+str(b))
    d=int(str(b)+str(a))
    return c-d