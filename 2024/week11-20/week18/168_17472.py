import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
n,m=map(int,input().split())
map_var=[]
for i in range(n):
    map_var.append(list(map(int,input().split())))
    for j in range(m):
        if map_var[i][j]==1:
            map_var[i][j]=-1

def find(x):
    if parents[x]<0:
        return x
    else:
        y=find(parents[x])
        parents[x]=y
        return y
def union(a,b):
    root_a=find(a)
    root_b=find(b)
    if root_a==root_b:
        return False
    if parents[root_a]<parents[root_b]:
        parents[root_a]+=parents[root_b]
        parents[root_b]=root_a
    else:
        parents[root_b] += parents[root_a]
        parents[root_a] = root_b
    return True

land_start_point=[]
def iden_land(id,a,b):
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    for k in range(4):
        next_i=a+di[k]
        next_j=b+dj[k]
        if next_i<0 or next_j<0 or next_i>n-1 or next_j>m-1:
            continue
        else:
            if map_var[next_i][next_j]==-1:
                map_var[next_i][next_j]=id
                iden_land(id,next_i,next_j)
id=1
for i in range(n):
    for j in range(m):
        if map_var[i][j]==-1:
            map_var[i][j]=id
            land_start_point.append([id,i,j])
            iden_land(id,i,j)
            id+=1
parents=[-1for _ in range(id)]
def check_line(dir,next_i,next_j,id):
    di = [0, 1, 0, -1]
    dj = [1, 0, -1, 0]
    distance=0
    while True:
        next_i += di[dir]
        next_j += dj[dir]
        if next_i < 0 or next_j < 0 or next_i > n - 1 or next_j > m - 1:
            return None
        else:
            if map_var[next_i][next_j]==id:
                return None
            else:
                if map_var[next_i][next_j]!=0:
                    if distance<2:
                        return None
                    union(id,map_var[next_i][next_j])
                    return [distance,map_var[next_i][next_j]]
        distance += 1

bridges=[]
visit=[[0 for _ in range(m)]for _ in range(n)]
def iden_bridge(id,a,b):
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    for k in range(4):
        next_i=a+di[k]
        next_j=b+dj[k]
        if next_i<0 or next_j<0 or next_i>n-1 or next_j>m-1:
            continue
        else:
            if visit[next_i][next_j]==0:
                if map_var[next_i][next_j]==id:
                    visit[next_i][next_j]=1
                    iden_bridge(id,next_i,next_j)
                else:
                    check_result=check_line(k,a,b,id)
                    if check_result!=None:
                        bridges.append([check_result[0],check_result[1],id])

for i in land_start_point:
    visit[i[1]][i[2]]=1
    iden_bridge(i[0],i[1],i[2])

bridges.sort()

for i in range(2,id):
    if find(1)!=find(i):
        print(-1)
        exit()

result=0
parents=[-1for _ in range(id)]
for i in range(len(bridges)):
    if union(bridges[i][1],bridges[i][2]):
        result+=bridges[i][0]
print(result)