# 2×n 타일링

## 문제 설명
- 문제 링크: [링크](https://www.acmicpc.net/problem/11726)
- 핵심 사항:
  - ""
---

## 접근 방법
- n 크기에 따른 방법의 수
  - 1 : 1
  - 2 : 2
  - 3 : 3
  - 4 : 5
  - 5 : 8
  - 6 : 13
- n = (n-1)+(n-2)
### 해석
- 2×1 타일을 세로로 한 개 놓는 경우:
  - 이 경우, 마지막 열(n)에 2×1 하나를 세로로 놓는 것
  - 남은 부분은 2×(n-1) 크기의 직사각형이고, 이것을 채우는 경우의 수는 f(n-1)

- 1×2 타일을 가로로 두 개 나란히 놓는 경우:
  - 이 경우, 마지막 두 열(n-1과 n)에 1×2 타일 두 개를 가로로 놓는 것
  - 그러면 남은 부분은 2×(n-2) 크기의 직사각형이고, 이것을 채우는 경우의 수는 f(n-2)

## 구현
- 구현