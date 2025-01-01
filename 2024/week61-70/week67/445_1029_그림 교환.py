n=int(input())
prices=[list(map(int,input().strip())) for _ in range(n)]

dp=[[[0 for _ in range(10)] for _ in range(n)] for _ in range(1<<(n))]
visit=[0 for _ in range(n)]

result=0
def dfs(v,prev_price,count,bit):
    global result
    result=max(result,count)
    if dp[bit][v][prev_price]:
        return
    dp[bit][v][prev_price]=count
    for i in range(n):
        if v!=i and prices[v][i]>=prev_price and visit[i]==0:
            visit[i]=1
            dfs(i,prices[v][i],count+1,bit+(1<<i))
            visit[i]=0

visit[0]=1
dfs(0,0,1,1)
print(result)