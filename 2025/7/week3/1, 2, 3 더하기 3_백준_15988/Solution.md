# 1, 2, 3 더하기 3

## 문제 설명
- 문제 링크: [링크](https://www.acmicpc.net/problem/15988)
- 핵심 사항:
  - "합을 나타낼 때는 수를 1개 이상 사용해야 한다."
  - "정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수"
  - "테스트 케이스의 개수 T가 주어진다."
  - "n은 양수이며 100,000보다 작거나 같다."
  - "방법의 수를 1,000,000,009로 나눈 나머지를 출력"
---

## 접근 방법
- `dp[i]`: i를 만들 때 방법의 수
- 점화식 구성
  - ```java
    dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    ```