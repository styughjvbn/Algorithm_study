import sys

input=sys.stdin.readline

n=int(input())

green_area=[[0 for _ in range(4)] for _ in range(6)]
blue_area=[[0 for _ in range(4)] for _ in range(6)]
def place_block(arr,move_type,coord):
    if move_type==3:#2칸 체크
        prev_layer=0
        for i in range(6):
            if arr[i][coord[0]]==0 and arr[i][coord[1]]==0:
                prev_layer=i
            else:
                break
        arr[prev_layer][coord[0]]=1
        arr[prev_layer][coord[1]]=1
    else:
        prev_layer=0
        for i in range(6):
            if arr[i][coord[0]]==0:
                prev_layer=i
            else:
                break
        if move_type==1:#1x1크기의 블럭
            arr[prev_layer][coord[0]]=1
        else:
            arr[prev_layer-1][coord[0]]=1
            arr[prev_layer][coord[0]]=1

def check_score(arr):
    add_score=0
    new_area=[]
    for i in range(6):
        temp=sum(arr[i])
        if temp==4:
            add_score+=1
        elif temp!=0:
            new_area.append(arr[i])
    if len(new_area)>4:
        new_area=new_area[:4]
    new_area=[[0 for _ in range(4)] for _ in range(6-len(new_area))]+new_area

    return new_area,add_score

def calc_tile_count(arrs:list[list]):
    cc=0
    for i in arrs:
        for j in range(6):
            cc+=i[j].count(1)

    return cc
total_score=0
for _ in range(n):
    t,x,y=map(int,input().split())
    if t==1:
        place_block(green_area,t,[y])
        green_area,score=check_score(green_area)
        total_score+=score
        place_block(blue_area,t,[x])
        blue_area,score=check_score(blue_area)
        total_score+=score
    elif t==2:
        place_block(green_area,3,[y,y+1])
        green_area,score=check_score(green_area)
        total_score+=score
        place_block(blue_area,t,[x])
        blue_area,score=check_score(blue_area)
        total_score+=score
    else:
        place_block(green_area,2,[y])
        green_area,score=check_score(green_area)
        total_score+=score
        place_block(blue_area,3,[x,x+1])
        blue_area,score=check_score(blue_area)
        total_score+=score
    # for i in green_area:
    #     print(*i)
    # print()
    # for i in zip(*blue_area):
    #     print(*i)

print(total_score)
print(calc_tile_count([green_area,blue_area]))