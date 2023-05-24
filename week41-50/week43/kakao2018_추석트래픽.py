def solution(lines):
    timetable = []
    answer = 0
    for i in range(len(lines)):
        log = lines[i].split()
        process_sec = int(float(log[2][:-1]) * 1000)
        time = log[1].split(":")
        hour = (int(time[0]) * 3600000)
        mini = (int(time[1]) * 60000)
        sec = int(float(time[2]) * 1000)
        timetable.append([hour + mini + sec - process_sec + 1, hour + mini + sec])
    print(timetable)
    for i in range(len(timetable)):
        num1 = 0
        num2 = 0
        for j in range(len(timetable)):
            if timetable[i][1] + 1000 > timetable[j][0] and timetable[i][1] <= timetable[j][1]:
                num1 += 1
            if timetable[i][0] + 1000 > timetable[j][0] and timetable[i][0] <= timetable[j][1]:
                num2 += 1
        answer = max(answer, num1, num2)

    return answer