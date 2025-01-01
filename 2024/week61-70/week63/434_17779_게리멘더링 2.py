n = int(input())
world = [list(map(int, input().split())) for _ in range(n)]
total_num=sum(map(sum,world))
def calc_1(i,j,d1,d2):
    num=1
    result=0
    for k in range(i+d1):
        if k<i:
            result+=sum(world[k][:j+1])
        else:
            result+=sum(world[k][:j+1-num])
            num+=1
    return result

def calc_2(i,j,d1,d2):
    num=1
    result=0
    for k in range(i+d2+1):
        if k<=i:
            result+=sum(world[k][j+1:])
        else:
            result+=sum(world[k][j+1+num:])
            num+=1
    return result

def calc_3(i,j,d1,d2):
    global n
    num=j-d1
    result=0
    for k in range(i+d1,n):
        if k>i+d1+d2:
            result+=sum(world[k][:j-d1+d2])
        else:
            result+=sum(world[k][:num])
            num+=1
    return result

def calc_4(i,j,d1,d2):
    global n
    num=j+d2
    result=0
    for k in range(i+d2+1,n):
        if k>i+d1+d2:
            result+=sum(world[k][j-d1+d2:])
        else:
            result+=sum(world[k][num:])
            num-=1
    return result

result=2000000
for i in range(n):
    for j in range(n):
        for d1 in range(1,n):
            if j-d1<0:
                break
            for d2 in range(1,n):
                if j+d2>=n or i+d1+d2>=n:
                    break
                nums=[]
                nums.append(calc_1(i,j,d1,d2))
                nums.append(calc_2(i,j,d1,d2))
                nums.append(calc_3(i,j,d1,d2))
                nums.append(calc_4(i,j,d1,d2))
                nums.append(total_num-sum(nums))
                # print(i,j,d1,d2)
                # print(nums)
                result=min(result,max(nums)-min(nums))
print(result)