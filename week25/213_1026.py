n=int(input())
num1=list(map(int,input().split()))
num2=list(map(int,input().split()))

num1.sort(reverse=True)
num2.sort()

result=0
for i in range(n):
    result+=num1[i]*num2[i]

print(result)