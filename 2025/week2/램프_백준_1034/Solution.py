import sys

input = sys.stdin.readline

n,m = map(int,input().split())
kindsOfRow = {}
for _ in range(n):
    row = input().strip()
    if row not in kindsOfRow:
        kindsOfRow[row] = 1
    else:
        kindsOfRow[row]+=1
k = int(input())
kIsOdd = k%2
result = 0
for key in kindsOfRow.keys():
    zeroCount = 0
    for c in key:
        if c == '0':
            zeroCount+=1
    if zeroCount > k:
        continue
    if zeroCount%2 == kIsOdd:
        result = max(result, kindsOfRow[key])
print(result)