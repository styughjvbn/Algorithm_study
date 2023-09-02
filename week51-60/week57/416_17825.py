from itertools import product
dice=list(map(int,input().split()))
#도착 = 0
main_route=[[i,0] for i in range(0,41,2)]#1
route_10=[[10,0],[13,0],[16,0],[19,0]]#2
route_20=[[20,0],[22,0],[24,0]]#3
route_30=[[30,0],[28,0],[27,0],[26,0]]#4
route_25=[[25,0],[30,0],[35,0],[40,0]]#5
route_list=[None,main_route,route_10,route_20,route_30,route_25]
max_score=0
horse=[[1,0] for _ in range(4)]

def moving_on_25(cur_pos,next_pos,horse_num):
    if cur_pos+next_pos>=len(route_25):
        horse[horse_num][0]=0
        return 0
    elif cur_pos+next_pos==len(route_25)-1:
        if main_route[-1][1]==1:
            return None
        else:
            main_route[-1][1]=1
            horse[horse_num][0]=1
            horse[horse_num][1]=len(main_route)-1
            return 40
    else:
        if route_25[cur_pos+next_pos][1]==1:
            return None
        else:
            route_25[cur_pos+next_pos][1]=1
            horse[horse_num][0]=5
            horse[horse_num][1]=cur_pos+next_pos
            return route_25[cur_pos+next_pos][0]

def move(horse_num,move_num):
    cur_pos=horse[horse_num][1]
    cur_path=horse[horse_num][0]
    next_pos=cur_pos+move_num
    route_list[cur_path][cur_pos][1]=0#이전 경로의 말 유무 제거
    if cur_path==1:#메인 경로
        if next_pos>=len(main_route):#메인 경로의 범위를 벗어 났을 때 현재 말의 경로를 완료로 바꾸고 0리턴
            horse[horse_num][0]=0
            horse[horse_num][1]=0
            return 0
        if main_route[next_pos][0] == 10:#메인 경로 중에서 10 파란색 칸에 도달
            if route_10[0][1]==1:#10 파란색에 말이 존재한다면 None 리턴
                return None
            else:#존재하지 않는다면 말을 이동
                route_10[0][1]=1#첫번째 칸에 말이 존재 표시
                horse[horse_num][0]=2#현재 경로를 route_10으로 변경
                horse[horse_num][1]=0#현재 경로 위에서 위치 변경
                return route_10[0][0]
        elif main_route[next_pos][0] == 20:
            if route_20[0][1]==1:
                return None
            else:
                route_20[0][1]=1
                horse[horse_num][0]=3
                horse[horse_num][1]=0
                return route_20[0][0]
        elif main_route[next_pos][0] == 30:
            if route_30[0][1]==1:
                return None
            else:
                route_30[0][1]=1
                horse[horse_num][0]=4
                horse[horse_num][1]=0
                return route_30[0][0]
        else:#일반적인 상황이라면
            if main_route[next_pos][1] == 1:
                return None
            else:
                main_route[next_pos][1] = 1
                horse[horse_num][1]=next_pos
                return main_route[next_pos][0]
    else:
        if cur_path in [2,3,4]:
            cur_path_list=route_list[cur_path]
            if next_pos>=len(cur_path_list):
                horse[horse_num][0]=5#현재 경로를 해당 경로로 변경
                return moving_on_25(0,next_pos-len(cur_path_list),horse_num)
            else:
                if cur_path_list[next_pos][1]==1:
                    return None
                else:
                    cur_path_list[next_pos][1]=1
                    horse[horse_num][1]=next_pos
                    return cur_path_list[next_pos][0]
        else:
            return moving_on_25(cur_pos,move_num,horse_num)


def init():
    for i in main_route:
        i[1]=0
    for i in route_10:
        i[1]=0
    for i in route_20:
        i[1]=0
    for i in route_30:
        i[1]=0
    for i in route_25:
        i[1]=0
def play(arr):
    global horse
    horse=[[1,0] for _ in range(4)]
    init()
    temp_score=0
    for idx,horse_num in enumerate(arr):
        if horse[horse_num][0]==0:
            return 0
        temp_num=move(horse_num, dice[idx])
        if temp_num is None:
            return 0
        # print(temp_num)
        temp_score+=temp_num
    return temp_score

temp_arr=(1, 1, 1, 1, 1, 1, 1, 1, 0, 0)

for i in product([0,1,2,3],repeat=10):
    # flag=True
    # for j in zip(temp_arr,i):
    #     if j[0]!=j[1]:
    #         flag=False
    # if flag:
    #     print("ss",i)
    #     print(play(i))
    max_score=max(max_score,play(i))
print(max_score)

# temp_arr=(1, 1, 1, 1, 1, 1, 1, 1, 0, 0)
# print(play(temp_arr))