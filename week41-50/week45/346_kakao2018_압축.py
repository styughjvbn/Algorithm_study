def solution(msg):
    answer = []
    dic = {}
    for i in range(26):
        dic[chr(65 + i)] = i + 1
    index = 0
    max_len = 1
    idx = 27
    start_index = 0
    while index < len(msg):
        temp = ""
        start_index = index
        flag = False
        for i in range(index, len(msg)):
            temp += msg[i]
            if temp not in dic.keys():
                answer.append(dic[temp[:-1]])
                flag = True
                break
            index = i + 1
        if flag:
            dic[temp] = idx
            idx += 1

    answer.append(dic[msg[start_index:]])
    print(dic)
    print(start_index, index, len(msg), msg[start_index:])
    return answer