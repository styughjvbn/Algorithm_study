import sys
input=sys.stdin.readline

n,k=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]
board_hole=[[[] for _ in range(n)] for _ in range(n)]
piece=[]
for i in range(k):
    a,b,c=map(int,input().split())
    a,b,c=a-1,b-1,c-1
    board_hole[a][b].append(i)
    piece.append([a,b,c])

di=[0,0,-1,1]
dj=[1,-1,0,0]
result=0
def move_forward(i,j,ni,nj,index,reverse=False):
    global result,k
    idx=board_hole[i][j].index(index)
    remain=board_hole[i][j][:idx]
    moving=board_hole[i][j][idx:]
    for l in moving:
        piece[l][0]=ni
        piece[l][1]=nj
    if reverse:
        moving.reverse()
    board_hole[ni][nj].extend(moving)
    if len(board_hole[ni][nj])>=4:
        print(result)
        exit()
    board_hole[i][j]=remain

while result<=1000:
    result+=1
    # for v in range(n):
    #     for b in range(n):
    #         temp_str=""
    #         for s in board_hole[v][b]:
    #             temp_str+=str(s)
    #             if piece[s][2]==0:
    #                 temp_str+=">"
    #             elif piece[s][2]==1:
    #                 temp_str+="<"
    #             elif piece[s][2]==2:
    #                 temp_str+="^"
    #             elif piece[s][2]==3:
    #                 temp_str+="-"
    #         print(board[v][b],end="")
    #         print("{0:>10}".format(temp_str),end=" | ")
    #     print("\n----------------------------------------------------------------------------")
    # print()
    # print("===================================================================================")
    # print()
    for index,value in enumerate(piece):
        i,j,d=value
        ni=i+di[d]
        nj=j+dj[d]
        if 0<=ni<n and 0<=nj<n:
            if board[ni][nj]==0:
                move_forward(i,j,ni,nj,index)
            elif board[ni][nj]==1:
                move_forward(i,j,ni,nj,index,reverse=True)
            else:
                if piece[index][2]==1:
                    piece[index][2]=0
                elif piece[index][2]==0:
                    piece[index][2]=1
                if piece[index][2]==2:
                    piece[index][2]=3
                elif piece[index][2]==3:
                    piece[index][2]=2

                ni=i+di[piece[index][2]]
                nj=j+dj[piece[index][2]]
                if 0<=ni<n and 0<=nj<n and board[ni][nj]!=2:
                    if board[ni][nj]==0:
                        move_forward(i,j,ni,nj,index)
                    else:
                        move_forward(i,j,ni,nj,index,reverse=True)
        else:
            if piece[index][2]==1:
                piece[index][2]=0
            elif piece[index][2]==0:
                piece[index][2]=1
            if piece[index][2]==2:
                piece[index][2]=3
            elif piece[index][2]==3:
                piece[index][2]=2
            ni=i+di[piece[index][2]]
            nj=j+dj[piece[index][2]]
            if 0<=ni<n and 0<=nj<n and board[ni][nj]!=2:
                if board[ni][nj]==0:
                    move_forward(i,j,ni,nj,index)
                else:
                    move_forward(i,j,ni,nj,index,reverse=True)

print(-1)
