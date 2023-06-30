import sys
import math
input=sys.stdin.readline

#조합을 이용한 풀이
for _ in range(int(input())):
    a,b=map(int,input().split())
    print(math.comb(b,a))