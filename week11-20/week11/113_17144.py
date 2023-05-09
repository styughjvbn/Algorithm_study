import sys
R,C,T=map(int,sys.stdin.readline().split())

room=[]
conditioner_pos=[]
dust_pos=[]
for i in range(R):
    room.append(list(map(int,sys.stdin.readline().split())))
    for j in range(C):
        if room[i][j]==-1:
            conditioner_pos.append([i,j])
        if room[i][j]!=-1 and room[i][j]!=0:
            dust_pos.append([i,j])
di=[0,1,0,-1]
dj=[1,0,-1,0]
def rotate_room():
    #0열 변환
    for p in range(conditioner_pos[0][0]-2,-1,-1):
        room[p+1][0]=room[p][0]
    room[0][0]=0
    for p in range(conditioner_pos[1][0]+2,R):
        room[p-1][0]=room[p][0]
    room[R-1][0]=0
    #맨위랑 맨아래 변환
    for j in range(1, C):
        room[0][j - 1] = room[0][j]
    room[0][C-1]=0
    for j in range(1, C):
        room[R-1][j - 1] = room[R-1][j]
    room[R-1][C-1]=0
    #맨오른쪽 변환
    for p in range(1,conditioner_pos[0][0]+1):
        room[p - 1][C-1] = room[p][C-1]
    room[conditioner_pos[0][0]][C-1] = 0
    for p in range(R-2, conditioner_pos[1][0]-1, -1):
        room[p + 1][C-1] = room[p][C-1]
    room[conditioner_pos[1][0]][C-1] = 0
    # 맨위랑 맨아래 변환
    for j in range(C-2, 0,-1):
        room[conditioner_pos[0][0]][j + 1] = room[conditioner_pos[0][0]][j]
    room[conditioner_pos[0][0]][1] = 0
    for j in range(C-2, 0,-1):
        room[conditioner_pos[1][0]][j + 1] = room[conditioner_pos[1][0]][j]
    room[conditioner_pos[1][0]][1] = 0


for i in range(T):
    temp_room=[[0for _ in range(C)]for _ in range(R)]

    for dust_i,dust_j in dust_pos:
        increments=room[dust_i][dust_j]//5
        spread_count=0
        for k in range(4):
            next_i=dust_i+di[k]
            next_j=dust_j+dj[k]
            if next_i<0 or next_i>=R or next_j<0 or next_j>=C or room[next_i][next_j]==-1:
                continue
            else:
                temp_room[next_i][next_j]+=increments
                spread_count+=1
        temp_room[dust_i][dust_j]+=room[dust_i][dust_j]-(increments*spread_count)
    room=temp_room
    room[conditioner_pos[0][0]][conditioner_pos[0][1]]=-1
    room[conditioner_pos[1][0]][conditioner_pos[1][1]] = -1

    rotate_room()
    dust_pos=[]
    for z in range(R):
        for x in range(C):
            if room[z][x]!=-1and room[z][x]!=0:
                dust_pos.append([z,x])
result=0
for z in range(R):
    for x in range(C):
        if room[z][x]!=-1and room[z][x]!=0:
            result+=room[z][x]
print(result)



