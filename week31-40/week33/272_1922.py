import sys
input=sys.stdin.readline

def find(x):
    #유니온 파인드 알고리즘의 집합의 루트를 찾는 함수
    if computer[x]<0:
        return x
    else:
        computer[x]=find(computer[x])
        return computer[x]

def union(x,y):
    #유니온 파인드 알고리즘의 원소들을 하나의 집합으로 합치는 함수
    root_x=find(x)
    root_y=find(y)
    if root_x==root_y:
        return False
    else:
        if root_y<root_x:
            computer[root_y]+=computer[root_x]
            computer[root_x]=root_y
        else:
            computer[root_x]+=computer[root_y]
            computer[root_y]=root_x
        return True

N=int(input())
M=int(input())

#유니온 파인드의 각 집합을 표현한다. 처음에는 컴퓨터 개수만큼의 원소가 1개씩인 집합이 N개 존재한다.
computer=[-1 for _ in range(N)]

#컴퓨터끼리의 경로을 입력받고 비용을 기준으로 오름차순 정렬한다.
line=[]
for i in range(M):
    a,b,c=map(int,input().split())
    line.append([a,b,c])
line.sort(key=lambda a:a[2])

#Kruskal MST 알고리즘에 따라 비용이 작고 집합에 존재하지 않는 경로를 선택한다.
result=0
for i in range(M):
    a,b,c=line[i]
    if union(a-1,b-1):
        result+=c
print(result)