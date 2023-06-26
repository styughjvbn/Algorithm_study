num_board=[list(map(str,input().split())) for _ in range(5)]

result=[]
di=[0,1,0,-1]
dj=[1,0,-1,0]
def dfs(string,i,j):
    if len(string)==6:
        if int(string) in result:
            return
        else:
            result.append(int(string))
        return
    else:
        for k in range(4):
            ni=i+di[k]
            nj=j+dj[k]
            if ni<0 or ni>=5 or nj<0 or nj>=5:
                continue
            else:
                dfs(string+num_board[ni][nj],ni,nj)

for p in range(5):
    for l in range(5):
        dfs(num_board[p][l],p,l)

print(len(result))