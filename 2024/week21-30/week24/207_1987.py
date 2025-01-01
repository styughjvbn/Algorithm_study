import sys

input=sys.stdin.readline

R,C=map(int,input().split())

board=[]
for i in range(R):
    board.append(list(input().strip()))
alpabet=[0]*26
result=0
dx=[0,1,0,-1]
dy=[1,0,-1,0]
def dfs(a,b,count):
    global result
    result = max(result, count)
    for i in range(4):
        next_a=dx[i]+a
        next_b=dy[i]+b
        if next_a<0 or next_b<0 or next_a>=R or next_b>=C or alpabet[ord(board[next_a][next_b])-65]!=0:
            continue
        else:
            alpabet[ord(board[next_a][next_b])-65]=1
            dfs(next_a,next_b,count+1)
            alpabet[ord(board[next_a][next_b]) - 65] = 0


alpabet[ord(board[0][0])-65]=1
dfs(0,0,1)
print(result)