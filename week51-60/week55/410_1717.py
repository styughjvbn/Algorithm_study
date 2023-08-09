import sys

sys.setrecursionlimit(10**7)
input=sys.stdin.readline

def union(a,b):
    find_a=find(a)
    find_b=find(b)
    if find_a==find_b:
        return False
    else:
        if find_a<find_b:
            nums[find_a]+=nums[find_b]
            nums[find_b]=find_a
        else:
            nums[find_b]+=nums[find_a]
            nums[find_a]=find_b
        return True
def find(a):
    if nums[a]<0:
        return a
    else:
        nums[a]=find(nums[a])
        return  nums[a]

n,m=map(int,input().split())
nums=[-1 for _ in range(n+1)]
for i in range(m):
    operand,a,b=map(int,input().split())
    if operand==0:
        union(a,b)
    else:
        find_a=find(a)
        find_b=find(b)
        if find_a==find_b:
            print("YES")
        else:
            print("NO")