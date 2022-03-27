import sys

sys.setrecursionlimit(10 ** 6)

def move(circle, base, goal):
    if(circle<2):
        print(base, goal)
        return
    move((circle) - 1, base, 6 - base - goal)
    print(base, goal)
    move((circle) - 1, 6 - base - goal, goal)

n = int(sys.stdin.readline().strip())
print((2**n)-1)
move(n,int(1),int(3))
