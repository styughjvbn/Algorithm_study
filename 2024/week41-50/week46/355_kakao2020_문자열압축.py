def solution(s):
    answer = len(s)
    for i in range(1, (len(s)) // 2 + 1):
        start = 0
        end = i
        prev_word = s[start:end]
        start = end
        end += i
        pres_word = ""
        num = 1
        temp_len = 0
        while end < len(s) + 1:
            pres_word = s[start:end]
            if prev_word == pres_word:
                num += 1
            else:
                temp_len += i
                if num != 1:
                    temp_len += len(str(num))
                num = 1
            prev_word = pres_word
            start = end
            end += i

        temp_len += i
        if num != 1:
            temp_len += len(str(num))
        temp_len += len(s) - start
        answer = min(answer, temp_len)

    return answer