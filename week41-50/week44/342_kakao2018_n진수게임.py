def solution(n, t, m, p):
    answer = ''
    num = 0
    order = 0
    while len(answer) < t:
        pick_num = convert(n, num)
        for i in pick_num:
            if len(answer) >= t:
                break
            if order + 1 == p:
                answer += i
            order = ((order + 1) % m)
        num += 1

    disit = 1
    # while len(answer)<t:

    return answer


def convert(n, num):
    number = ""
    temp = {10: "A", 11: "B", 12: "C", 13: "D", 14: "E", 15: "F"}
    while num > n - 1:
        tmp = (num % n)
        if tmp >= 10:
            tmp = temp[tmp]
        number = str(tmp) + number
        num //= n
    tmp = (num % n)
    if tmp >= 10:
        tmp = temp[tmp]
    return str(tmp) + number