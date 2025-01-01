n,m=map(int,input().split())

#1~n 까지의 리스트 생성
queue=[i for i in range(1,n+1)]
num=map(int, input().split())
#큐안에서 참조하는 인덱스
point=0
#큐 안에 남은 숫자 개수
remain_n=n
result=0
for i in num:
    count=0
    while True:
        #큐 안의 모든 인덱스를 순회하면서 이번 순서에 뽑아야할 숫자를 찾는다.
        if queue[point]==i:#숫자를 찾았다면
            queue[point]=0#0으로 바꿔서 이미 빠진 숫자를 표시
            if count>remain_n//2:#남아있는 숫자의 개수의 절반보다 순회한 횟수가 크다면 반대로 순회했을 때가 최소값
                count=remain_n-count
            result+=count
            remain_n-=1#남아있는 숫자의 개수 표시
            break
        else:
            if queue[point]!=0:#숫자를 못찾고 다른 인덱스를 순회한다면 순회한 횟수를 기록
                count+=1
            point=(point+1)%n#모듈러 연산
print(result)
