import sys
from collections import deque

input = sys.stdin.readline

initBoardState = [[0 for _ in range(8)] for _ in range(8)]
farthestWall = 8
for i in range(8):
    line = input().strip()
    for j in range(8):
        initBoardState[i][j] = line[j]
        if farthestWall == 8 and line[j] == '#':
            farthestWall = i
# print("가장 먼 벽 "+str(farthestWall))
di = [0,0,1,1,1,0,-1,-1,-1]
dj = [0,1,1,0,-1,-1,-1,0,1]
queue = deque()
queue.append((7,0,0))
reachable = False

while queue:
    curI,curJ,time = queue.popleft()
    # print(curI,curJ,time)
    for k in range(9):
        ni = curI + di[k]
        nj = curJ + dj[k]
        if 0 <= ni < 8 and 0 <= nj < 8: #체스판의 범위 제한 확인
            if initBoardState[ni-time][nj] == '.': #이동한 칸이 빈칸인지 확인
                if ni <= farthestWall+time: #이동한 칸이 모든 벽들을 다 지나쳤는지 확인
                    reachable = True
                    break
                if initBoardState[ni-time-1][nj] =='.': #이동한 칸에 벽이 내려오는지 확인
                    queue.append((ni,nj,time+1))
    if reachable:
        break
print("1" if reachable else "0")