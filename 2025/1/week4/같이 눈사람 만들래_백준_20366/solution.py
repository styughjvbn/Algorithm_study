import sys

input = sys.stdin.readline

n = int(input())
snowballs = list(map(int,input().split()))
snowballs.sort()
snowmans = []
for i in range(n):
    for j in range(i+1, n):
        snowmans.append((snowballs[i]+snowballs[j], i,j))
snowmans.sort(key=lambda a: a[0])
# print(snowmans)
minHeightDiff = 2_000_000_001
for i in range(len(snowmans)-1):
    if len({snowmans[i][1], snowmans[i][2], snowmans[i+1][1], snowmans[i+1][2]}) == 4:
        minHeightDiff = min(minHeightDiff, snowmans[i+1][0]-snowmans[i][0])
print(minHeightDiff)