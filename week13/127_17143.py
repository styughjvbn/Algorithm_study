import sys

R,C,M=map(int,sys.stdin.readline().split())
shark=[]
sea=[[-1 for _ in range(C)]for _ in range(R)]
for i in range(M):
    shark.append(list(map(int,sys.stdin.readline().split())))
    shark[i][0]-=1
    shark[i][1] -= 1
    sea[shark[i][0]][shark[i][1]]=i
result=0

# for i in range(C):
#     print(*sea[i])
# print()
for i in range(C):
    for j in range(R):
        if sea[j][i]!=-1:
            result+=shark[sea[j][i]][4]
            shark[sea[j][i]][4]=-1
            break

    sea = [[-1 for _ in range(C)] for _ in range(R)]
    for j in range(len(shark)):
        if shark[j][4]==-1:
            continue
        a,b=0,0
        distance = shark[j][2]

        if shark[j][3]>2:#왼쪽 오른쪽일떄

            if shark[j][3]==4:
                distance+=((C-1)-shark[j][1])+(C-1)

            else:
                distance += shark[j][1]

            distance = distance % ((C - 1) * 2)

            if distance>C-1:
                shark[j][3] = 4
            else:
                shark[j][3] = 3
            a,b=shark[j][0],(C-1)-abs((C-1)-distance)

        else:
            if shark[j][3] == 1:
                distance += ((R - 1) - shark[j][0]) + (R - 1)
            else:
                distance += shark[j][0]
            distance = distance % ((R - 1) * 2)
            if distance > R - 1:
                shark[j][3] = 1
            else:
                shark[j][3] = 2
            a, b = (R - 1) - abs((R - 1) - distance),shark[j][1]
        if sea[a][b]!=-1:
            if shark[sea[a][b]][4]<shark[j][4]:
                shark[sea[a][b]][4]=-1
                shark[j][0]=a
                shark[j][1]=b
                sea[a][b]=j
            else:
                shark[j][4]=-1
        else:
            shark[j][0] = a
            shark[j][1] = b
            sea[a][b] = j
    # for a in range(C):
    #     print(*sea[a])
    # print(i,"번째 이동 끝")
print(result)