import sys
import heapq
input=sys.stdin.readline

n=int(input())
card_set=[int(input()) for _ in range(n)]
heapq.heapify(card_set)
result=0
while len(card_set)>1:
    card1=heapq.heappop(card_set)
    card2=heapq.heappop(card_set)
    result+=card1+card2
    heapq.heappush(card_set,card1+card2)
print(result)