import sys
from collections import deque
input = sys.stdin.readline
di = [0,1,0,-1]
dj = [1,0,-1,0]

n = int(input())
world = [list(map(int, input().split())) for _ in range(n)]

# 섬 구분
visited = [[0 for _ in range(n)] for _ in range(n)]
flag = 1
## 각 섬이 바다와 맞닿는 테두리 저장
islandOutline = {}
for i in range(n):
    for j in range(n):
        if world[i][j] == 1:
            flag+=1
            world[i][j] = flag
            queue = deque()
            queue.append([i,j])
            visited[i][j] = flag
            islandOutline[flag] = deque()
            while queue:
                pos = queue.popleft()
                for k in range(4):
                    ni = pos[0]+di[k]
                    nj = pos[1]+dj[k]
                    if 0 <= ni < n and 0 <= nj < n:
                        if visited[ni][nj] != flag:
                            if world[ni][nj] == 1:
                                visited[ni][nj] = world[ni][nj] = flag
                                queue.append([ni,nj])
                            if world[ni][nj] == 0:
                                islandOutline[flag].append([ni,nj, 0])

# 섬 구분 확인
# for i in range(n):
#     for j in range(n):
#         print(world[i][j], end=" ")
#     print()

# 모든 섬들을 출발지점으로 가장 짧은 다리 탐색
result = 20000
flag+=10000
for islandId, outline in islandOutline.items():
    flag+=1
    breakFlag = False
    while outline and not breakFlag:
        posi, posj, dis = outline.popleft()
        for k in range(4):
            ni = posi + di[k]
            nj = posj + dj[k]
            if 0<=ni<n and 0<=nj<n:
                if visited[ni][nj]!=flag:
                    if world[ni][nj] == 0:
                        visited[ni][nj]=flag
                        outline.append([ni,nj, dis+1])
                    elif world[ni][nj] != islandId:
                        result = min(result, dis+1)
                        breakFlag = True
                        break

print(result)