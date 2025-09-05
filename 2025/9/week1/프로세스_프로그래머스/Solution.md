# 프로세스

## 문제 설명
- 문제 링크: [링크](https://school.programmers.co.kr/learn/courses/30/lessons/42587)
- 핵심 사항:
  - ""
---

## 접근 방법
- 더 높은 우선순위의 프로세스가 존재하는지를 우선순위큐로 판단
  - deque에서 뽑은 프로세스의 우선순위가 현재 제일 높은 우선순위라면 제거, 아니라면 다시 deque에 삽입