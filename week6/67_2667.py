import sys

n=int(sys.stdin.readline().strip())
map=[0]*n
for i in range(n):
    map[i]=list(sys.stdin.readline().strip())

def dfs(i,j):
    global map
    global count
    if map[i][j]!='0':
        map[i][j]='0'
        count+=1
        if j>0:
            dfs(i,j-1)
        if j<n-1:
            dfs(i,j+1)
        if i<n-1:
            dfs(i+1,j)
        if i>0:
            dfs(i-1,j)
    else:
        return
result=[]
for i in range(n):
    for j in range(n):
        count = 0
        dfs(i,j)
        if(count!=0):
            result.append(count)
result.sort()
print(len(result))
for i in result:
    print(i)



