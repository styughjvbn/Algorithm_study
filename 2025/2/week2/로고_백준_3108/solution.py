import sys

input = sys.stdin.readline

class UnionFind():
    def __init__(self, size):
        self.rootRank = [-1 for _ in range(size)]
        self.size = size

    def find(self,a:int):
        if self.rootRank[a] < 0:
            return a
        self.rootRank[a] = self.find(self.rootRank[a])
        return self.rootRank[a]
    
    def union(self, a:int, b:int) -> bool:
        rootA = self.find(a)
        rootB = self.find(b)

        if rootA == rootB:
            return False
        
        if self.rootRank[rootA]>self.rootRank[rootB]:
            self.rootRank[rootB] += self.rootRank[rootA]
            self.rootRank[rootA] = rootB
        else:
            self.rootRank[rootA] += self.rootRank[rootB]
            self.rootRank[rootB] = rootA
        return True

def paintPoint(i, j, x):
    if board[i][j] != -1:
        unionFind.union(x,board[i][j])
    else:
        board[i][j] = x
MAX_RANGE = 1000
n = int(input())
unionFind = UnionFind(n+1)
board = [[-1 for _ in range(MAX_RANGE+1)] for _ in range(MAX_RANGE+1)]
board[MAX_RANGE//2][MAX_RANGE//2] = 0
for square in range(1, n+1):
    x1,y1,x2,y2 = map(lambda a: int(a)+MAX_RANGE//2,input().split())
    for i in range(y2-y1+1):
        paintPoint(y1+i, x1, square)
        paintPoint(y2-i, x2, square)
    for i in range(x2-x1-1):
        paintPoint(y1, x1+i+1, square)
        paintPoint(y2, x2-i-1, square)

# for _ in range(MAX_RANGE+1):
#     for __ in range(MAX_RANGE+1):
#         print(f"{board[_][__] if board[_][__]>=0 else 'x'}", end= " ") 
#     print()

result = set()
for idx, rootRankValue in enumerate(unionFind.rootRank):
    if rootRankValue < 0:
        result.add(idx)
print(len(result)-1)