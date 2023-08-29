import sys
from copy import deepcopy

input=sys.stdin.readline

n,m,t=map(int,input().split())
circle_boards=[list(map(int,input().split())) for _ in range(n)]
board_start=[0 for _ in range(n)]
# print()
# for i in range(n):
#     for j in range(m):
#         index=(board_start[i]+j)%m
#         print(circle_boards[i][index],end=" ")
#     print()
# print()
for _ in range(t):
    x,d,k=map(int,input().split())

    if d==1:
        for i in range(x,n+1,x):
            board_start[i-1]=((board_start[i-1])+k)%m
    else:
        for i in range(x,n+1,x):
            board_start[i-1]=((board_start[i-1])+(m-k))%m

    # print("after rotation")
    # for i in range(n):
    #     for j in range(m):
    #         index=(board_start[i]+j)%m
    #         print(circle_boards[i][index],end=" ")
    #     print()
    # print()

    temp_circle_board=deepcopy(circle_boards)
    is_exist=False
    total,count=0,0
    for i in range(n):
        for j in range(m):
            is_same=False
            index=(board_start[i]+j)%m
            if circle_boards[i][index]==0:
                continue
            total+=circle_boards[i][index]
            count+=1
            if circle_boards[i][index]==circle_boards[i][(index-1)%m]:
                temp_circle_board[i][(index-1)%m]=0
                is_same=True
            if circle_boards[i][index]==circle_boards[i][(index+1)%m]:
                temp_circle_board[i][(index+1)%m]=0
                is_same=True
            if i+1<n and circle_boards[i][index]==circle_boards[i+1][(board_start[i+1]+j)%m]:
                temp_circle_board[i+1][(board_start[i+1]+j)%m]=0
                is_same=True
            if i-1>0 and circle_boards[i][index]==circle_boards[i-1][(board_start[i-1]+j)%m]:
                temp_circle_board[i-1][(board_start[i-1]+j)%m]=0
                is_same=True
            if is_same:
                is_exist=True
                temp_circle_board[i][index]=0
            # print(i,j,"111")
            # for ii in range(n):
            #     for jj in range(m):
            #         index=(board_start[ii]+jj)%m
            #         print(temp_circle_board[ii][index],end=" ")
            #     print()
            # print()
    if not is_exist and count>0:
        total_mean=total/count
        for i in range(n):
            for j in range(m):
                if circle_boards[i][j]!=0:
                    if circle_boards[i][j]>total_mean:
                        circle_boards[i][j]-=1
                    elif circle_boards[i][j]<total_mean:
                        circle_boards[i][j]+=1
        # print(total_mean)
    else:
        circle_boards=temp_circle_board

    print("after change")
    for i in range(n):
        for j in range(m):
            print(circle_boards[i][j],end=" ")
        print()
    print()

print(sum(map(sum,circle_boards)))