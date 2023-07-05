import sys

input=sys.stdin.readline

n=int(input())
krain=sorted(list(map(int,input().split())))
m=int(input())
box=sorted(list(map(int,input().split())))

weight_set=[[] for _ in range(n)]
temp_set=[]
base=0
for i in box:
    if i>krain[base]:
        base+=1
    try:
        weight_set[base].append(i)
    except:
        print(-1)
        exit()
result=0
remain_box=m
while remain_box:
    result += 1
    impossible=True
    for i in range(n-1,-1,-1):
        for j in range(i,-1,-1):
            if len(weight_set[j]) and min(weight_set[j])<=krain[i]:
                weight_set[j].pop()
                remain_box-=1
                impossible=False
                break
    if impossible:
        print(-1)
        exit()
print(result)