import sys

n,m=map(int,sys.stdin.readline().split())
mage=[0]*n
chicken=[]
house=[]
for i in range(n):
    mage[i]=list(map(int,sys.stdin.readline().split()))
    for j in range(n):
        if mage[i][j]==2:
            chicken.append([i,j])
        if mage[i][j]==1:
            house.append([i,j])

arr=[0]*m
result=int(1e9)
def dfs(a,b,temp):
    global result
    if b==m:
        result=count_dist(temp,result)

        return
    else:
        for i in range(a+1,len(chicken)):
            temp[b]=chicken[i]
            dfs(i,b+1,temp)

def count_dist(temp,min_chicken_dist):

    chicken_dist=0
    for i in house:
        min_dist = 150
        for j in temp:
            min_dist=min(abs(i[0]-j[0])+abs(i[1]-j[1]),min_dist)
        if chicken_dist+min_dist>min_chicken_dist:
            return min_chicken_dist

        chicken_dist += min_dist

    return chicken_dist

for i in range(len(chicken)):
    arr[0]=chicken[i]
    dfs(i,1,arr)
print(result)