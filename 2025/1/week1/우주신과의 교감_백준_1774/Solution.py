class UnionFind:
    def __init__(self, n):
        self.parantRank = [-1 for _ in range(n)]

    def find(self,x):
        if self.parantRank[x] < 0:
            return x
        self.parantRank[x] = self.find(self.parantRank[x])
        return self.parantRank[x]
    
    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX == rootY:
            return False
        
        if self.parantRank[rootX] > self.parantRank[rootY]:
            self.parantRank[rootY] += self.parantRank[rootX]
            self.parantRank[rootX] = rootY
        else:
            self.parantRank[rootX] += self.parantRank[rootY]
            self.parantRank[rootY] = rootX
        return True
    
import sys
import math
input = sys.stdin.readline

n,m = map(int,input().split())
unionFind = UnionFind(n)
gods = []
distanceBetweenGods = []
connectionCount = 0
result = 0
for id in range(n):
    x,y = map(int,input().split())
    for targetId, pos in enumerate(gods):
        distanceBetweenGods.append((math.sqrt(math.pow(pos[0]-x, 2)+math.pow(pos[1]-y, 2)), id, targetId))
    gods.append([x,y])

for _ in range(m):
    a,b = map(int,input().split())
    if unionFind.union(a-1,b-1):
        connectionCount += 1
distanceBetweenGods.sort(key=lambda a:a[0])

for edgs in distanceBetweenGods:
    dis,a,b = edgs
    if unionFind.union(a,b):
        connectionCount+=1
        result+=dis
    if connectionCount>=n-1:
        break
print(f"{result:.02f}")