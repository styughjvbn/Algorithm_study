import sys
input=sys.stdin.readline
N=int(input())
krain=list(map(int,input().split()))
M=int(input())
box=list(map(int,input().split()))
box_visit=[0]*M
box_num=M
krain.sort(reverse=True)
box.sort(reverse=True)

time=0
while True:
    index = 0
    time += 1
    prev=box_num
    for i in range(M):
        if box[i]<=krain[index] and box_visit[i]==0:
            index+=1
            box_visit[i]=1
            box_num-=1
            if box_num<=0:
                print(time)
                exit()
            if index==N:
                break

    if prev==box_num and box_num>0:
        print(-1)
        exit()
