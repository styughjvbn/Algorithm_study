def sol(N, M, a):
    s, e = 0, 0
    subsum = a[0]
    cnt = 0
    while True:
        if subsum < M:  # 작으면 end point +1
            e += 1
            if e >= N:  # 인덱스 범위 주의
                break
            subsum += a[e]
        elif subsum == M:  # 같으면 cnt +1
            cnt += 1
            subsum -= a[s]
            s += 1
        else:  # 크면 start point +1
            subsum -= a[s]
            s += 1
    return cnt


N, M = map(int, input().split())
a = list(map(int, input().split()))
print(sol(N, M, a))