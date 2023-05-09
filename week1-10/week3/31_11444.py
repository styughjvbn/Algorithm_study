import sys
#(Fn+1  Fn )=(1 1)^n
#( Fn  Fn-1) (1 0)
#피보나치 수열은 위와같은 행렬식으로 대치 가능하다고한다...
input = sys.stdin.readline

B=int(sys.stdin.readline().strip())
N=2
A=[[1,1],[1,0]]

def mul(U, V):
    n = len(U)
    Z = [[0] * n for _ in range(n)]

    for row in range(n):
        for col in range(n):
            e = 0
            for i in range(n):
                e += U[row][i] * V[i][col]
            Z[row][col] = e % 1000000007

    return Z


def square(A, B):
    if B == 1:
        for x in range(len(A)):
            for y in range(len(A)):
                A[x][y] %= 1000000007
        return A

    tmp = square(A, B // 2)
    if B % 2:
        return mul(mul(tmp, tmp), A)
    else:
        return mul(tmp, tmp)


result = square(A, B)
print(result[0][1])