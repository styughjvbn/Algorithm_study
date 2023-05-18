def solution(dartResult):
    answer = 0
    plus = {"S": 1, "D": 2, "T": 3}
    score = [0, 0, 0]
    chance = 0
    i = 0
    while i < len(dartResult):
        if dartResult[i].isdigit():
            if dartResult[i + 1].isdigit():
                score[chance] = 10 ** plus[dartResult[i + 2]]
                i += 2
            else:
                score[chance] = int(dartResult[i]) ** plus[dartResult[i + 1]]
                i += 1
            chance += 1
        else:
            if dartResult[i] == "*":
                score[chance - 1] *= 2
                if chance - 2 >= 0:
                    score[chance - 2] *= 2
            elif dartResult[i] == "#":
                score[chance - 1] *= -1
            i += 1

    return sum(score)