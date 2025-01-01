import sys

n=int(sys.stdin.readline())
height=0
width=0
leng=[]
for i in range(6):
    direc,long=map(int,sys.stdin.readline().split())
    if direc==3 or direc==4:
        height=max(height,long)
    else:
        width=max(width,long)

    leng.append([direc,long])

temp=0

for i in range(12):
    if leng[i%6][0]==3 and leng[(i+1)%6][0]!=1:
        temp=leng[i%6][1]*leng[(i+1)%6][1]
    if leng[i%6][0]==1 and leng[(i+1)%6][0]!=4:
        temp=leng[i%6][1]*leng[(i+1)%6][1]
    if leng[i%6][0]==4 and leng[(i+1)%6][0]!=2:
        temp=leng[i%6][1]*leng[(i+1)%6][1]
    if leng[i%6][0]==2 and leng[(i+1)%6][0]!=3:
        temp=leng[i%6][1]*leng[(i+1)%6][1]


print((width*height-temp)*n)