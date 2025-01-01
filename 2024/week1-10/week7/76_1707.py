import sys
sys.setrecursionlimit(10 ** 6)
#두그룹으로 나누어 서로 인접한 정점들을 서로 다른 색으로 칠하다가 이미 색이 칠해진 정점을 만났을때 나의 색과 인접한 정점의 색이 같다면 이분그래프가 아니다.
#완전히 떨어져 있는 그룹을 생각하지 못해서 헤맸다.
def DFS(count,color):
    global result
    for i in E[count]:
        if visit[i]==0:
            if color==1:
                visit[i]=2
                DFS(i,2)
            else:
                visit[i]=1
                DFS(i,1)
        else:
            if visit[count]==visit[i]:
                result=1
    return

k=int(sys.stdin.readline())
for _ in range(k):
    v,e=map(int,sys.stdin.readline().split())
    E={}
    visit=[0]*v
    result = 0
    for i in range(v):
        E[i]=[]
    for i in range(e):
        a,b=map(lambda a: int(a)-1,sys.stdin.readline().split())
        E[a].append(b)
        E[b].append(a)
    for i in range(v):
        if visit[i]==0:
            DFS(i, 1)
    if result:
        print("NO")
    else:
        print("YES")
