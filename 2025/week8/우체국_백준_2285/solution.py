import sys

input = sys.stdin.readline

n = int(input())
postOffices = []
totalPopulation = 0
for _ in range(n):
    postOffice = list(map(int,input().split()))
    totalPopulation+=postOffice[1]
    postOffices.append(postOffice)

postOffices.sort(key=lambda a: a[0])

acc = 0
for i in range(n):
    acc+= postOffices[i][1]
    if acc*2 >= totalPopulation:
        print(postOffices[i][0])
        break