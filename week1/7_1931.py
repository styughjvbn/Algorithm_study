import sys

n=int(sys.stdin.readline().strip())

arr=[]
for i in range(n):
    arr.append(list(map(int,sys.stdin.readline().split())))
#시작시간으로 오름차순 정렬후 종료시간으로 오름차순 정렬한다.
count=0
arr.sort(key=lambda tmp:tmp[0])
arr.sort(key=lambda tmp:tmp[1])
flag=0
# 종료시간을 기준으로 오름차순 정렬되어 있기 때문에
# 배열 내의 원소를 순서대로 확인하면서 진행된 회의의 종료시간 보다 큰 시작시간을 가진 원소를
# 발견하면 회의 배정을 한 후에 진행된 회의의 종료시간을 업데이트한다.
for i,j in arr:
    if i>=flag:
        count+=1
        flag=j
print(count)