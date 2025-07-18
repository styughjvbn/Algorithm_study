# 가장 긴 증가하는 부분 수열

## 문제 설명
- 문제 링크: [링크](https://www.acmicpc.net/problem/11053)
- 핵심 사항:
  - "수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램"
  - "첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 **길이**를 출력"
---

## 접근 방법
- `dp[i]`: 수열이 Ai 까지만 존재할 때 가장 긴 증가하는 부분 수열의 길이
  - 예를 들어, A = {10, 20, 10, 30} 일 때, 
    - `dp[0]`: 1
    - `dp[1]`: 2
    - `dp[2]`: 2
  - `i` 보다 작은 `j`에 대해서 `A[j]<A[i]`인 경우 `dp[j]+1`의 최대값으로 구할 수 있다.