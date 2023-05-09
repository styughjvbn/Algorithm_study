import sys

input=sys.stdin.readline

N,M=map(int,input().split())

g_string_sets_min=1001
g_string_single_min=1001
result=0
for _ in range(M):
    sets,single=map(int,input().split())
    g_string_sets_min=min(sets,g_string_sets_min)
    g_string_single_min = min(single, g_string_single_min)

print(min(N//6*g_string_sets_min,N//6*6*g_string_single_min)+min(N%6*g_string_single_min,g_string_sets_min))