# 카드 구매하기 2

## 문제 설명
- 문제 링크: [링크](https://www.acmicpc.net/problem/16194)
- 핵심 사항:
  - "N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최솟값"
  - "구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다."
---

## 접근 방법
- `dp[i]`: 카드 i개를 구매하기 위해 지불할 수 있는 최소 금액
- 점화식 구성
  - ```java
        for (int i = 1; i <= n; i++) {
            dp[i] = cardPackPrices[i]; //카드 i개를 구매하기 위해 Pi를 선택하는 것을 기본값으로 지정
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cardPackPrices[j]);
            }
        }
```