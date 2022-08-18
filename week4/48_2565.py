import sys
#두 전봇대 A와 B 사이에 연결된 두 전깃줄 t1, t2가 있다고 하자. 이때 두 전깃줄이 겹치지 않는 조건은 다음과 같다.
#전봇대 A에서 t1 < t2라면, 전봇대 B에서도 t1 < t2다.
#전봇대 A에서 t1 > t2라면, 전봇대 B에서도 t1 > t2다.
#전봇대 A를 기준으로 정렬후에 B에 연결된 전기줄의 LIS를 구한다면 구한 LIS가 교차하지 않는 최대 전기줄의 개수이다.
n=int(sys.stdin.readline().strip())
arr=[]
for i in range(n):
    arr.append(list(map(int,sys.stdin.readline().split())))
arr.sort(key=lambda x:x[0])

dp=[0]*n
for i in range(n):
    big=dp[i]
    for j in range(i):
        if arr[i][1]>arr[j][1] and dp[j]>big:
            big=dp[j]
    dp[i]=big+1

print(n-max(dp))