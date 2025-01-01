def solution(clothes):
    answer = 1
    count_per_type={}
    for i in clothes:
        if count_per_type.get(i[1]):
            count_per_type[i[1]]+=1
        else:
            count_per_type[i[1]]=1
    for i in count_per_type.values():
        answer*=i+1
    return answer-1