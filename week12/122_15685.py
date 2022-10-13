import sys

n=int(sys.stdin.readline())
coordinate_plane=[[0 for _ in range(101)]for _ in range(101)]
def draw_line(start_dir,gene,start):
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    next_i=start[0]
    next_j=start[1]
    coordinate_plane[next_i][next_j]=1
    permutation=[start_dir]
    for i in range(gene):
        for j in range(2**(i)-1,-1,-1):
            permutation.append((permutation[j]+3)%4)
    for i in permutation:
        next_i=next_i+di[i]
        next_j = next_j + dj[i]
        coordinate_plane[next_i][next_j]=1

for i in range(n):
    x,y,d,g=map(int,sys.stdin.readline().split())
    if d==1:
        d=3
    elif d==3:
        d=1
    draw_line(d,g,[y,x])

result=0
for i in range(100):
    for j in range(100):
        count=0
        if coordinate_plane[i][j]==1:
            count+=1
        if coordinate_plane[i+1][j]==1:
            count+=1
        if coordinate_plane[i][j+1]==1:
            count+=1
        if coordinate_plane[i+1][j+1]==1:
            count+=1
        if count==4:
            result+=1
print(result)
