def solution(files):
    answer = []
    filename = []
    for i in range(len(files)):
        flag = False
        number = ""
        for j in files[i]:
            if j.isdigit():
                number += j
                flag = True
            if flag and not j.isdigit():
                break
        filesplit = files[i].split(number)
        filename.append([files[i], filesplit[0].lower(), int(number), filesplit[1]])

    filename.sort(key=lambda a: a[2])
    filename.sort(key=lambda a: a[1])
    for i in range(len(files)):
        answer.append(filename[i][0])
    print(filename)
    return answer