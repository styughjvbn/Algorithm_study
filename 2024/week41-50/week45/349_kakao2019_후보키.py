from itertools import combinations


def solution(relation):
    answer = 0
    rows = len(relation)
    columns = len(relation[0])

    case = []
    for i in range(1, columns + 1):
        case.append(list(combinations(range(columns), i)))

    unique = []
    for i in range(len(case)):
        for l in case[i]:
            temp = set()
            for k in range(rows):
                string = ""
                for j in l:
                    string += relation[k][j]
                temp.add(string)
            if len(temp) == rows:
                unique.append(set(l))
    minimal = []
    for i in range(len(unique)):
        flag = True
        for j in range(len(minimal)):
            if len(minimal[j] & unique[i]) == len(minimal[j]):
                flag = False
        if flag:
            minimal.append(unique[i])
    print(minimal)
    return len(minimal)