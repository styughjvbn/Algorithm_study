import sys

n,m,i,j,k=map(int,sys.stdin.readline().split())
real_map=[]
for _ in range(n):
    real_map.append(list(map(int,sys.stdin.readline().split())))
move=list(map(lambda a:int(a)-1,sys.stdin.readline().split()))
def move_dice(var_dice,dir):
    if dir==0:
        temp=var_dice[0]
        var_dice[0]=var_dice[3]
        var_dice[3]=var_dice[5]
        var_dice[5]=var_dice[2]
        var_dice[2]=temp
    elif dir==1:
        temp = var_dice[0]
        var_dice[0] = var_dice[2]
        var_dice[2] = var_dice[5]
        var_dice[5] = var_dice[3]
        var_dice[3] = temp
    elif dir==2:
        temp = var_dice[0]
        var_dice[0] = var_dice[4]
        var_dice[4] = var_dice[5]
        var_dice[5] = var_dice[1]
        var_dice[1] = temp
    elif dir==3:
        temp = var_dice[0]
        var_dice[0] = var_dice[1]
        var_dice[1] = var_dice[5]
        var_dice[5] = var_dice[4]
        var_dice[4] = temp
    return var_dice
di=[0,0,-1,1]
dj=[1,-1,0,0]
dice=[0,0,0,0,0,0]
for a in range(k):
    next_i=i+di[move[a]]
    next_j=j+dj[move[a]]

    if next_i<0 or next_i>=n or next_j<0 or next_j>=m:
        pass
    else:
        dice = move_dice(dice, move[a])
        if real_map[next_i][next_j]==0:
            real_map[next_i][next_j] =dice[5]
        else:
            dice[5]=real_map[next_i][next_j]
            real_map[next_i][next_j] = 0
        i, j = next_i, next_j
        print(dice[0])


