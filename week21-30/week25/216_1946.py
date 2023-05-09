import sys

input=sys.stdin.readline

T=int(input())
for _ in range(T):
    n=int(input())
    scores=[]
    for i in range(n):
        scores.append(list(map(int,input().split())))

    scores.sort()
    min_score=scores[0][1]
    result = 1
    for i in range(1,n):
        if scores[i][1]<min_score:
            result+=1
            min_score=scores[i][1]

    print(result)

