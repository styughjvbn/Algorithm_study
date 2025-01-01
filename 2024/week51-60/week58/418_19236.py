import sys
from copy import deepcopy

input = sys.stdin.readline

bowl = [[-1 for _ in range(4)] for _ in range(4)]
fishes = [[] for _ in range(16)]
for i in range(4):
    row = list(map(int, input().split()))
    for j in range(0, 8, 2):
        fishes[row[j] - 1] = [row[j + 1] - 1, i, j // 2]
        bowl[i][j // 2] = row[j] - 1

di = [-1, -1, 0, 1, 1, 1, 0, -1]
dj = [0, -1, -1, -1, 0, 1, 1, 1]

temp=[ "↑", "↖", "←","↙","↓", "↘", "→", "↗" ]
result=0
def step(shark_pos, bowl, fishes, score):
    global result
    # 상어 움직임
    fish_num = bowl[shark_pos[0]][shark_pos[1]]
    # print(fish_num,score,result)
    score+=fish_num+1
    bowl[shark_pos[0]][shark_pos[1]] = 16
    # print(fishes[fish_num][1],fishes[fish_num][2])
    shark_dir = fishes[fish_num][0]
    fishes[fish_num][0] = -1

    # print("상어 식사 후")
    # for i in range(4):
    #     for j in range(4):
    #         if bowl[i][j]==16:
    #             print("{1:<2}{0:<2} ".format("ss",temp[shark_dir]),end="")
    #         else:
    #             print("{1:<2}{0:<2} ".format(bowl[i][j]+1,temp[fishes[bowl[i][j]][0]]),end="")
    #     print()

    # 물고기들 움직임
    for i in range(16):
        if fishes[i][0] == -1:
            continue
        else:
            direc = fishes[i][0]
            # 모든 방향 체크
            for j in range(8):
                direc = (fishes[i][0] + j) % 8
                next_i = fishes[i][1] + di[direc]
                next_j = fishes[i][2] + dj[direc]
                # 움직일 공간이 있다면
                if 0 <= next_i < 4 and 0 <= next_j < 4 and bowl[next_i][next_j] != 16:
                    if bowl[next_i][next_j] == -1:
                        bowl[fishes[i][1]][fishes[i][2]] = -1
                        bowl[next_i][next_j] = i
                        fishes[i][1] = next_i
                        fishes[i][2] = next_j
                    else:
                        dest_fish = bowl[next_i][next_j]
                        bowl[next_i][next_j] = i
                        bowl[fishes[i][1]][fishes[i][2]] = dest_fish
                        fishes[dest_fish][1] = fishes[i][1]
                        fishes[dest_fish][2] = fishes[i][2]
                        fishes[i][1] = next_i
                        fishes[i][2] = next_j
                    fishes[i][0] = direc
                    break
            # print(str(i+1)+"번 상어 이동 완료")
            # for i in range(4):
            #     for j in range(4):
            #         if bowl[i][j]==16:
            #             print("{1:<2}{0:<2} ".format("ss",temp[shark_dir]),end="")
            #         else:
            #             print("{1:<2}{0:<2} ".format(bowl[i][j]+1,temp[fishes[bowl[i][j]][0]]),end="")
            #     print()

    # print("물고기 움직인후 ")
    # for i in range(4):
    #     for j in range(4):
    #         if bowl[i][j]==16:
    #             print("{1:<2}{0:<2} ".format("ss",temp[shark_dir]),end="")
    #         else:
    #             print("{1:<2}{0:<2} ".format(bowl[i][j]+1,temp[fishes[bowl[i][j]][0]]),end="")
    #     print()
    for i in range(1, 4):
        next_i = shark_pos[0] + di[shark_dir] * i
        next_j = shark_pos[1] + dj[shark_dir] * i

        if 0 <= next_i < 4 and 0 <= next_j < 4 and bowl[next_i][next_j] != -1:
            bowl[shark_pos[0]][shark_pos[1]]=-1
            step([next_i,next_j], list(deepcopy(bowl)), list(deepcopy(fishes)),score)
    result=max(result,score)
step([0,0],bowl,fishes,0)
print(result)