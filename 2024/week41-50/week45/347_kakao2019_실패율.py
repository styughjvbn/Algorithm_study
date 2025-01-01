def solution(N, stages):
    answer = []
    stages.sort()
    player_num = 0
    total_num = len(stages)
    base = stages[0]
    for i in range(1, N + 1):
        num = stages.count(i)
        if num:
            answer.append([i, num / total_num])
            total_num -= num
        else:
            answer.append([i, 0])
    answer.sort(key=lambda a: a[1], reverse=True)
    nw_ans = []
    for i in answer:
        nw_ans.append(i[0])

    return nw_ans