n=int(input())
dice=list(map(int,input().split()))

def vertex():
    l_sum=[]
    l_sum.append(dice[0]+dice[1]+dice[2])
    l_sum.append(dice[0] + dice[1] + dice[3])
    l_sum.append(dice[0] + dice[4] + dice[3])
    l_sum.append(dice[0] + dice[4] + dice[2])
    l_sum.append(dice[5] + dice[1] + dice[2])
    l_sum.append(dice[5] + dice[1] + dice[3])
    l_sum.append(dice[5] + dice[4] + dice[3])
    l_sum.append(dice[5] + dice[4] + dice[2])
    return min(l_sum)

def corner():
    l_sum = []
    l_sum.append(dice[0] + dice[1])
    l_sum.append(dice[0] + dice[2])
    l_sum.append(dice[0] + dice[3])
    l_sum.append(dice[0] + dice[4])
    l_sum.append(dice[1] + dice[2])
    l_sum.append(dice[2] + dice[4])
    l_sum.append(dice[4] + dice[3])
    l_sum.append(dice[3] + dice[1])
    l_sum.append(dice[5] + dice[1])
    l_sum.append(dice[5] + dice[2])
    l_sum.append(dice[5] + dice[3])
    l_sum.append(dice[5] + dice[4])
    return min(l_sum)

if n<=1:
    print(sum(dice)-max(dice))
else:
    result=vertex()*4
    result+=((n-1)*4+(n-2)*4)*corner()
    result+=(5*((n-2)**2)+(n-2)*4)*min(dice)
    print(result)