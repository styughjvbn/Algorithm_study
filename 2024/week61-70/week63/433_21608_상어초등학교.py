import sys
import heapq

input = sys.stdin.readline

n = int(input())
students = []
fav_stds = []
for i in range(n * n):
    line = list(map(int, input().split()))
    students.append(line[0])
    fav_stds.append(line[1:])
classroom = [[0 for _ in range(n)] for _ in range(n)]

def compare(i, j, fav_std):
    di = [0, 1, 0, -1]
    dj = [1, 0, -1, 0]
    fav_std_num = 0
    empty_num = 0
    for k in range(4):
        ni = i + di[k]
        nj = j + dj[k]
        if 0 <= ni < n and 0 <= nj < n:
            if classroom[ni][nj] in fav_std:
                fav_std_num += 1
            if classroom[ni][nj] == 0:
                empty_num += 1
    return -fav_std_num, -empty_num, i, j


for k in range(n * n):
    candi_pos = []
    for i in range(n):
        for j in range(n):
            if classroom[i][j] != 0:
                continue
            else:
                heapq.heappush(candi_pos, compare(i, j, fav_stds[k]))
    _, _, pos_i, pos_j = heapq.heappop(candi_pos)
    classroom[pos_i][pos_j] = students[k]

result=0
for i in range(n):
    for j in range(n):
        fav_num, _, _, _=compare(i,j,fav_stds[students.index(classroom[i][j])])
        if fav_num==0:
            continue
        result+=10**(-fav_num-1)
print(result)