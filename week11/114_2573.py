import sys
sys.setrecursionlimit(10**6)
n,m=map(int,sys.stdin.readline().split())
ice=[]

visit=[[-1for _ in range(m)]for _ in range(n)]
ice_pos=[]

for i in range(n):
    ice.append(list(map(int,sys.stdin.readline().split())))
    for j in range(m):
        if ice[i][j]!=0:

            visit[i][j]=0
            ice_pos.append([i,j])


def dfs(i,j,var_temp_ice):
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    melt_ice = 0
    for k in range(4):
        next_i=i+di[k]
        next_j=j+dj[k]
        if ice[next_i][next_j]!=0 and visit[next_i][next_j]==0:
            visit[next_i][next_j]=1
            dfs(next_i,next_j,var_temp_ice)
        if ice[next_i][next_j] == 0:
            melt_ice+=1

    var_temp_ice[i][j]=ice[i][j]-melt_ice
    if var_temp_ice[i][j]<=0:
        visit[i][j]=-1
        var_temp_ice[i][j] = 0
        ice_pos.remove([i,j])

result=0
while len(ice_pos)>0:
    temp_ice = [[0 for _ in range(m)]for _ in range(n)]
    visit[ice_pos[0][0]][ice_pos[0][1]]=1
    dfs(ice_pos[0][0],ice_pos[0][1],temp_ice)

    ice = temp_ice

    for i in ice_pos:
        if visit[i[0]][i[1]] == 0:
            print(result)
            exit()
        if visit[i[0]][i[1]] == 1:
            visit[i[0]][i[1]] = 0

    result+=1
print(0)
