# 홀수 홀릭 호석

## 문제 설명
- 문제 링크: [링크](https://www.acmicpc.net/problem/20164)
- 핵심 사항:
  - "수의 각 자리 숫자 중에서 홀수의 개수를 종이에 적는다."
  - "수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다."
  - "수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다."
  - "수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다."
---

## 풀이 과정

### 1. **접근 방법**
- 메모리제이션과 재귀, 브루트포스 활용
- 3자리 수 이상의 값을 3개의 수로 나눌때 n이 최대 10^9-1이기 때문에 완전탐색을 하여도 시간복잡도 상으로 괜찮음
- 계산한 숫자마다 최솟값과 최댓값을 저장

### 2. **구현 단계**
- 구현
