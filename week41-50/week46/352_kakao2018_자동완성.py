answer = 0

def solution(words):
    words.sort()
    dfs(words, 0, len(words), 0)
    return answer

def dfs(words, start, end, num):
    global answer

    flag = False
    if len(words[start]) <= num:
        answer += len(words[start])
        flag = True
        start += 1
    if end - start == 0:
        return
    if end - start <= 1:
        if flag:
            answer += num + 1
        else:
            answer += num
        return
    else:
        base = words[start][num]
        for i in range(start + 1, end):
            if words[i][num] != base:
                dfs(words, start, i, num + 1)
                base = words[i][num]
                start = i

        else:
            dfs(words, start, end, num + 1)