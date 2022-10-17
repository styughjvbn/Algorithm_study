import sys
## elif의 오버헤드는 생각보다 크다..
## 높이의 범위가 원소들의 개수보다 적다면 높이별로 그룹핑해서 반복의 횟수를 획기적으로 줄일 수 있다.
input = sys.stdin.readline

N, M, B = map(int, input().split())
MAT = []
HEIS = [0 for _ in range(257)]
for n in range(N):
    T = list(map(int, input().split()))
    for m in range(M):
        HEIS[T[m]] += 1
    MAT.append(T)

m_res, h_res = float('inf'), 0
for h in range(257):
    p = 0
    m = 0
    for b in range(257):
        if h > b:
            p += (h - b) * HEIS[b]
        else:
            m += (b - h) * HEIS[b]
    inven = B + m - p
    if inven < 0:
        continue
    t = m * 2 + p
    if t <= m_res:
        m_res = t
        h_res = h

print(m_res, h_res)