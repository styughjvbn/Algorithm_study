import sys
input = sys.stdin.readline

# 입력 받기
num_gates = int(input())
num_airplanes = int(input())
airplanes = [int(input()) for _ in range(num_airplanes)]

# 변수 초기화
alters = list(range(num_gates+1)) # 대안 게이트

def find_root(airplane):
    stack = [airplane]

    while True:
        parking_gate = alters[airplane]

        if parking_gate == airplane:
            break
        else:
            stack.append(parking_gate)
            airplane = alters[parking_gate]

    while stack:
        temp = stack.pop()
        alters[temp] = parking_gate

    return parking_gate

def union(a,b):
    # b is bigger
    a_root = find_root(a)
    b_root = find_root(b)

    alters[a_root] = b_root

# 게이트 찾기

cnt = 0

for i in range(num_airplanes):
    airplane = airplanes[i]
    root = find_root(airplane)

    if root == 0:
        break

    union(root, root-1)
    #print(alters)
    cnt += 1

print(cnt)