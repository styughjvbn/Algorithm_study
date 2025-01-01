import sys
import heapq

class UnionFind:
    def __init__(self, size):
        self.parentRank = [ -1 for _ in range(size)]
        
    def find(self, x):
        if self.parentRank[x] < 0:
            return x
        self.parentRank[x] = self.find(self.parentRank[x])
        return self.parentRank[x]

    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX == rootY:
            return False
        
        if self.parentRank[rootX] > self.parentRank[rootY]:
            self.parentRank[rootY]+=self.parentRank[rootX]
            self.parentRank[rootX]=rootY
        else:
            self.parentRank[rootX]+=self.parentRank[rootY]
            self.parentRank[rootY]=rootX
        return True

n,m = map(int,sys.stdin.readline().split())
unionFind = UnionFind(n)
pq = []
connected = set()
connectedCount = 0
minimumCost = 0
pairNum = 0
answer = ""

for i in range(m):
    x,y = map(lambda a: int(a)-1, sys.stdin.readline().split())
    if unionFind.union(x,y):
        connectedCount+=1
    connected.add(1_000*x+y)

for i in range(n):
    costs = list(map(lambda a: int(a), sys.stdin.readline().split()))
    for j in range(i):
        if j == 0:
            continue
        if (i*1_000+j) in connected:
            continue
        heapq.heappush(pq,[costs[j],i*1_000+j])

while connectedCount < n-2 and len(pq)>0:
    cost, index = heapq.heappop(pq)
    # print(cost, index)
    x = index//1_000
    y = index%1_000
    if unionFind.union(x,y):
        connectedCount+=1
        minimumCost+=cost
        pairNum+=1
        answer+=str(x+1)+" "+str(y+1)+"\n"

print(str(minimumCost)+" "+str(pairNum))
print(answer)