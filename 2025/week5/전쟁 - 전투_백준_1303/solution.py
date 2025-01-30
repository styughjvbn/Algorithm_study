import sys
from collections import deque

input = sys.stdin.readline

m,n = map(int,input().split())
warBoard = [input().strip() for _ in range(n)]
visit = [[0 for _ in range(m)] for _ in range(n)]
di = [0,1,0,-1]
dj = [1,0,-1,0]

whitePower = 0
bluePower = 0
for i in range(n):
    for j in range(m):
        if visit[i][j] == 0:
            teamFlag = warBoard[i][j]
            soldierCount = 1
            queue = deque()
            queue.append((i,j))
            visit[i][j] = 1
            while queue:
                curI,curJ = queue.popleft()
                for k in range(4):
                    ni = curI + di[k]
                    nj = curJ + dj[k]
                    if 0<=ni<n and 0<=nj<m and visit[ni][nj]==0 and warBoard[ni][nj]==teamFlag:
                        visit[ni][nj] = 1
                        queue.append((ni,nj))
                        soldierCount+=1
            if teamFlag == 'W':
                whitePower += pow(soldierCount,2)
            else:
                bluePower += pow(soldierCount,2)
print(f"{whitePower} {bluePower}")