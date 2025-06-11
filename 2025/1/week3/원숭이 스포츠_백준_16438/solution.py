import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

queue = deque()

queue.append((1,1,n//2, 'A'))
queue.append((1,n//2+1,n, 'B'))
matching = ""
matchingList = []
depthCount = 0
prevDepth = 0
while queue:
    depth, low, high, team = queue.popleft()
    # print(depthCount)
    if prevDepth != depth:
        if matching != "":
            matchingList.append(matching)
        depthCount = 0
        matching = ""
    matching += (high-low+1)*team
    depthCount += 1
    prevDepth = depth
    if depthCount == n:
        matchingList.append(matching)
        break
    if (high-low+1) == 1:
        queue.append((depth+1, low, high, team))
    else:
        queue.append((depth+1, low, (low+high)//2, 'A'))
        queue.append((depth+1, (low+high)//2+1, high, 'B'))

# print(matchingList)
for i in range(7):
    print(matchingList[i%len(matchingList)])
