N, K = int(input()), int(input())
start, end = 1, K#k번째 수는 k를 넘을수 없기때문.
# 예를 들어 10 * 10에서 20보다 작거나 같은 수를 생각해보자.
# 1*1~1*10
# 2*1~2*10
# 3*1~3*6
# 10*1~10*2
#
# 위 수가 존재할텐데, 이는 반대로 생각해보면 20을 행으로 나눈 몫이다.
# 20//1: 10개 --> 단 열의 숫자(N*N배열이므로)를 초과할 수 없다.
# 20//2: 10개
# 20//3: 6개
# 20//10: 2개
# k보다 작은 수의 개수를 세면 k가 몇번째로 큰 수 인지 알수 있다.
while start <= end:
    mid = (start + end) // 2

    temp = 0
    for i in range(1, N + 1):
        temp += min(mid // i, N)  # mid 이하의 i의 배수 or 최대 N

    if temp >= K:  # 이분탐색 실행
        answer = mid
        end = mid - 1
    else:
        start = mid + 1
print(answer)