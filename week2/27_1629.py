import sys

#2^11=2^5*2^5*2이다
#2를 11번 곱하는 것보다 2를 5번곱한 값들 끼리 곱한 후에 2를 다시 곱해주면 총 7번으로 곱셈연산의
#횟수가 줄어든다.
a,b,c=map(int,sys.stdin.readline().split())

def mul(a,b,c):
    if b==1:
        return a%c
    temp=mul(a,b//2,c)

    if b%2==0:
        return temp*temp%c
    else:
        return temp*temp*a%c

print(mul(a,b,c))