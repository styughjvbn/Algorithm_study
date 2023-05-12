import sys
from itertools import permutations
input=sys.stdin.readline

n,m,k=map(int,input().split())
input_arr=[list(map(int,input().split())) for _ in range(n)]
rotate=[list(map(int,input().split())) for _ in range(k)]
def rotate_arr(r,c,s,arr):
    r,c=r-1,c-1
    temp=arr[r-s][c+s]
    for i in range(2*s,0,-1):
        arr[r-s][c-s+i]=arr[r-s][c-s+i-1]
    for i in range(2*s):
        arr[r-s+i][c-s]=arr[r-s+i+1][c-s]
    for i in range(2*s):
        arr[r+s][c-s+i]=arr[r+s][c-s+i+1]
    for i in range(2*s,0,-1):
        arr[r-s+i][c+s]=arr[r-s+i-1][c+s]
    arr[r-s+1][c+s]=temp

def rotate_all(r,c,s,arr):
    for i in range(1,s+1):
        rotate_arr(r,c,i,arr)
def calc_value(arr):
    min_value=100000
    for i in range(n):
        min_value=min(min_value,sum(arr[i]))
    return min_value
rotate_case=list(permutations(rotate,k))
# print(rotate_case)
result=100000
for i in range(len(rotate_case)):
    arr=[input_arr[i][:] for i in range(n)]

    for j in rotate_case[i]:
        rotate_all(j[0],j[1],j[2],arr)
    result=min(result,calc_value(arr))

print(result)