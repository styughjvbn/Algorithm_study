def solution(record):
    answer = []
    dict = {}
    temp_list = []
    for i in record:
        string = i.split()
        if string[0] != "Leave":
            dict[string[1]] = string[2]
        if string[0] != "Change":
            temp_list.append([string[0], string[1]])

    for i in temp_list:
        if i[0] == "Enter":
            answer.append(dict[i[1]] + "님이 들어왔습니다.")
        else:
            answer.append(dict[i[1]] + "님이 나갔습니다.")
    return answer