import sys

n,m=sys.stdin.readline().split()

arr=list(map(int,sys.stdin.readline().split()))
arr=[0]+arr
rest=[0]*int(m)

#구간합을 나머지로 구해둔다.
#나머지별로 개수를 세둔다.
for i in range(int(n)):
    arr[i+1]=(arr[i]+arr[i+1])%int(m)
    rest[arr[i+1]]+=1


#이미 나머지가 0인구간을 더한다.
count=rest[0]
#나머지가 같은 구간의 사이 구간은 나머지가 0이다
#나머지가 같은 구간들 중에서 2개를 뽑는 조합을 이용한다.
for k in rest:
    count+=k*(k-1)//2

print(count)