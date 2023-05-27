from itertools import combinations
import sys
input=sys.stdin.readline

while True:
    sets=list(map(int,input().split()))
    if sets[0]==0:
        exit()
    temp=list(combinations(sets[1:],6))
    for i in range(len(temp)):
        print(*temp[i])
    print()