import heapq


def solution(n, t, m, timetable):
    answer_time = 540 + t * (n - 1)
    temp = []
    for i in timetable:
        a = int(i.split(":")[0]) * 60 + int(i.split(":")[1])
        if a <= answer_time:
            temp.append(a)
    timetable = temp
    heapq.heapify(timetable)

    is_usable = False
    time = 540
    prev1 = 540
    for i in range(n):
        for j in range(m):
            if len(timetable) <= 0:
                is_usable = True
                break
            crew = heapq.heappop(timetable)
            if crew > time:
                heapq.heappush(timetable, crew)
                break
            print(i, j, crew)
            prev1 = crew
        time += t
    print(timetable, is_usable)
    print(prev1)

    if not is_usable:  # 자리가 안 남을때
        answer_time = prev1 - 1

    answer = '{:0>2}'.format(answer_time // 60) + ":" + '{:0>2}'.format(answer_time % 60)
    return answer