import sys

input = sys.stdin.readline

def operate(cogwheels, cogwheelPointers, curCogwheelNum, rotatedirection, nextDirection, rotate=True):
    nextCogwheelNum = curCogwheelNum+nextDirection
    if 0 <= nextCogwheelNum < 4:
        if nextDirection == 1:
            if cogwheels[curCogwheelNum][(cogwheelPointers[curCogwheelNum]+2)%8] != cogwheels[nextCogwheelNum][(cogwheelPointers[nextCogwheelNum]-2+8)%8]:
                operate(cogwheels, cogwheelPointers, nextCogwheelNum, rotatedirection*-1, 1)
        if nextDirection == -1:
            if cogwheels[nextCogwheelNum][(cogwheelPointers[nextCogwheelNum]+2)%8] != cogwheels[curCogwheelNum][(cogwheelPointers[curCogwheelNum]-2+8)%8]:
                operate(cogwheels, cogwheelPointers, nextCogwheelNum, rotatedirection*-1, -1)
    if rotate:
        cogwheelPointers[curCogwheelNum] = (cogwheelPointers[curCogwheelNum]+rotatedirection*-1+8)%8
        
def printCogwheel(cogwheels, cogwheelPointers):
    for id in range(4):
        for i in range(8):
            if cogwheels[id][(cogwheelPointers[id]+i)%8] == 0:
                print("N", end=" ")
            else:
                print("S", end=" ")
        print()

cogwheels = []
cogwheelPointers = [0 for _ in range(4)]
for _ in range(4):
    cogwheels.append(list(map(int,input().strip())))
# printCogwheel(cogwheels, cogwheelPointers)
for _ in range(int(input())):
    rotateCogwheelNum, rotateDirection = map(int, input().split())
    operate(cogwheels, cogwheelPointers, rotateCogwheelNum-1, rotateDirection, -1, False)
    operate(cogwheels, cogwheelPointers, rotateCogwheelNum-1, rotateDirection, 1)
    # print(f"{_}회차")
    # printCogwheel(cogwheels, cogwheelPointers)

result = 0
for id in range(4):
    result += (1<<id)*cogwheels[id][cogwheelPointers[id]]

print(result)