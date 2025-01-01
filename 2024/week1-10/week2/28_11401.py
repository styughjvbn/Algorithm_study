import sys
import math
#a ≡ b (mod m)는 a를 m으로 나눈 나머지와 b를 m으로 나눈 나머지가 서로 같다는 뜻이다.
#p가 소수이면, 모든 정수 a에 대해 a^p ≡ a(mod p)이다.
#p가 소수이고, a가 p의 배수가 아니면 a^(p-1) ≡ 1(mod p)이다.
#즉, 64^71≡64(mod 71)은 64의 71승의 71에 대한 나머지와 64의 71에 대한 나머지가 같고
#64^(71-1)≡1(mod 71)은 64의 70승의 71에 대한 나머지는 1이라는 것과 같다.

def power(a, b):
    if b == 0:
        return 1
    if b % 2:  # 홀수이면
        return (power(a, b // 2) ** 2 * a) % p
    else:
        return (power(a, b // 2) ** 2) % p


p = 1000000007
N, K = map(int, input().split())

# nCk를 나타내기 위해 팩토리얼을 dp로 구해줍니다.
fact = [1 for _ in range(N + 1)]

for i in range(2, N + 1):
    fact[i] = fact[i - 1] * i % p

# A는 nCk의 분자가되고 B는 분모가 됩니다.
A = fact[N]
B = (fact[N - K] * fact[K]) % p

#여기서 페르마의 소정리가 사용됨
print((A % p) * (power(B, p - 2) % p) % p)