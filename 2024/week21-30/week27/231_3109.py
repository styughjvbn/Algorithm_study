import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

R,C=map(int,input().split())

world=[]
for _ in range(R):
    world.append(list(input().strip()))
forwarda=[-1,0,1]

def DFS(i,j):
    if j==C-1:
        world[i][j]="O"
        return True
    flag=False
    for k in forwarda:
        if 0 <= i+k < R and world[i + k][j+1] == ".":
            world[i][j] = "O"
            if DFS(i + k, j + 1):
                flag=True
                break
    return flag


result=0
for i in range(R):
    # for l in range(R):
    #     print(*world[l])
    # print()
    world[i][0]='O'
    if DFS(i,0):
        result+=1
    # for l in range(R):
    #     print(*world[l])
    # print()
print(result)