import sys
import copy
sys.setrecursionlimit(10**6)
n,m=map(int,sys.stdin.readline().split())

office=[]
cctv=[]
for i in range(n):
    office.append(list(map(int,sys.stdin.readline().split())))
    for j in range(m):
        if office[i][j]!=0and office[i][j]!=6:
            cctv.append([office[i][j],i,j])

def drawline(office,next_i,next_j,dir):
    di = [0, 1, 0, -1]
    dj = [1, 0, -1, 0]
    while True:
        next_i = next_i + di[dir]
        next_j = next_j + dj[dir]
        if next_i > n - 1 or next_i < 0 or next_j > m - 1 or next_j < 0 or office[next_i][next_j] == 6:
            break
        else:
            if office[next_i][next_j] == 0:
                office[next_i][next_j] = -1
    return office

result=65
def dfs(dfs_office,iter):
    global result
    if iter==len(cctv):
        sum=0
        for i in dfs_office:
            for j in i:
                if j==0:
                    sum+=1
        result=min(result,sum)
        return
    else:
        if cctv[iter][0]==1:
            for i in range(4):
                dfs(drawline(copy.deepcopy(dfs_office),cctv[iter][1],cctv[iter][2],i),iter+1)
        if cctv[iter][0]==2:
            temp_office1=drawline(copy.deepcopy(dfs_office),cctv[iter][1],cctv[iter][2],0)
            temp_office1 = drawline(temp_office1, cctv[iter][1], cctv[iter][2], 2)
            dfs(temp_office1,iter+1)
            temp_office2 = drawline(copy.deepcopy(dfs_office), cctv[iter][1], cctv[iter][2], 1)
            temp_office2 = drawline(temp_office2, cctv[iter][1], cctv[iter][2], 3)
            dfs(temp_office2, iter + 1)
        if cctv[iter][0]==3:
            for i in range(4):
                temp_office=drawline(copy.deepcopy(dfs_office), cctv[iter][1], cctv[iter][2], i)
                temp_office = drawline(temp_office, cctv[iter][1], cctv[iter][2], (i+1)%4)
                dfs(temp_office, iter + 1)
        if cctv[iter][0]==4:
            for i in range(4):
                temp_office=drawline(copy.deepcopy(dfs_office), cctv[iter][1], cctv[iter][2], i)
                temp_office = drawline(temp_office, cctv[iter][1], cctv[iter][2], (i+1)%4)
                temp_office = drawline(temp_office, cctv[iter][1], cctv[iter][2], (i + 2) % 4)
                dfs(temp_office, iter + 1)
        if cctv[iter][0]==5:
                temp_office=drawline(copy.deepcopy(dfs_office), cctv[iter][1], cctv[iter][2], 0)
                temp_office = drawline(temp_office, cctv[iter][1], cctv[iter][2], 1)
                temp_office = drawline(temp_office, cctv[iter][1], cctv[iter][2], 2)
                temp_office = drawline(temp_office, cctv[iter][1], cctv[iter][2], 3)
                dfs(temp_office, iter + 1)

dfs((office),0)
print(result)