import sys

input=sys.stdin.readline

n,m,k=map(int,input().split())

bowl=[]
sharks_pos=[[] for _ in range(m)]
sharks_dir=[]
for i in range(n):
    line=list(map(int,input().split()))
    temp=[]
    for j in range(len(line)):
        if line[j]!=0:
            sharks_pos[line[j]-1]=[i,j]
            temp.append([line[j]-1,0,0])
        else:
            temp.append([-1,-1,0])
    bowl.append(temp)
sharks_dir=list(map(lambda a:int(a)-1, input().split()))
sharks_life=[1 for _ in range(m)]
di=[-1,1,0,0]
dj=[0,0,-1,1]
sharks_move_priority=[]

for i in range(m):
    temp=[list(map(lambda a:int(a)-1,input().split())) for _ in range(4)]
    sharks_move_priority.append(temp)

ss=[ '↑','↓', '←', '→']
# for i in range(m):
#     print(i+1)
#     for j in range(len(sharks_move_priority[i])):
#         print(ss[j],end=" : ")
#         for l in sharks_move_priority[i][j]:
#             print(ss[l],end=" ")
#         print()
#     print()
#
# for i in range(n):
#     for j in range(n):
#         if bowl[i][j][0]+1>0:
#             print(f'[{bowl[i][j][0]+1}, {bowl[i][j][1]}, {bowl[i][j][2]}] {ss[sharks_dir[bowl[i][j][0]]]}',end=" ")
#         else:
#             print(f'[0, 0, 0]  ',end=" ")
#     print()
# print()

t=0
while t<1001:
    t+=1
    if sum(sharks_life)==1:
        print(t-1)
        exit()

    for i in range(m):
        if sharks_life[i]==0:
            continue
        cur_i,cur_j=sharks_pos[i]
        cur_dir=sharks_dir[i]
        return_pos=[]
        return_dir=-1
        for j in range(4):
            next_dir=sharks_move_priority[i][cur_dir][j]
            next_i=cur_i+di[next_dir]
            next_j=cur_j+dj[next_dir]
            if 0<=next_i<n and 0<=next_j<n:
                if bowl[next_i][next_j][0]==i:
                    if return_dir == -1:
                        return_pos=[next_i,next_j]
                        return_dir=next_dir
                if bowl[next_i][next_j][0]!=-1 and bowl[next_i][next_j][1]==t and bowl[next_i][next_j][2]==-1:#현재 턴에 다른 상어가 이미 도착한 상태라면
                    if bowl[next_i][next_j][0]>i:
                        bowl[next_i][next_j][0]=i
                        bowl[next_i][next_j][1]=t
                        bowl[next_i][next_j][2]=-1
                        sharks_pos[i]=[next_i,next_j]
                        sharks_dir[i]=next_dir
                        break
                    else:
                        sharks_life[i]=0
                        break
                elif bowl[next_i][next_j][0]!=-1  and  bowl[next_i][next_j][1]+k<t:#다른 상어의 자취가 있었을 때 이미 자취의 기간이 지난 경우
                    bowl[next_i][next_j][0]=i
                    bowl[next_i][next_j][1]=t
                    bowl[next_i][next_j][2]=-1
                    sharks_pos[i]=[next_i,next_j]
                    sharks_dir[i]=next_dir
                    break
                elif bowl[next_i][next_j][0]==-1:
                    bowl[next_i][next_j][0]=i
                    bowl[next_i][next_j][1]=t
                    bowl[next_i][next_j][2]=-1
                    sharks_pos[i]=[next_i,next_j]
                    sharks_dir[i]=next_dir
                    break
        else:
            # print(return_pos,return_dir)
            if return_dir!=-1:
                bowl[return_pos[0]][return_pos[1]][0]=i
                bowl[return_pos[0]][return_pos[1]][2]=bowl[return_pos[0]][return_pos[1]][1]
                bowl[return_pos[0]][return_pos[1]][1]=t
                sharks_pos[i]=return_pos
                sharks_dir[i]=return_dir
    # print(t)
    # for i in range(n):
    #     for j in range(n):
    #         if bowl[i][j][1]+k<=t:
    #             print(f'[0, 0, 0]  ',end=" ")
    #         else:
    #             if bowl[i][j][0]+1>0 and bowl[i][j][1]==t:
    #                 print(f'[{bowl[i][j][0]+1}, {bowl[i][j][1]}, {bowl[i][j][2]}] {ss[sharks_dir[bowl[i][j][0]]]}',end=" ")
    #             else:
    #                 print(f'[{bowl[i][j][0]+1}, {bowl[i][j][1]}, {bowl[i][j][2]}]  ',end=" ")
    #     print()
    # print()
    # print(sharks_life)
    # print()
print(-1)