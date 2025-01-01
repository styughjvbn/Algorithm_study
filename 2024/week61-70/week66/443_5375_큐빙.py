k=int(input())

def swap(corner,direc,new,side):
    old_corner=[]
    if corner==1:#오른쪽 모서리
        if direc==1:#역시계방향
            for i in range(3):
                old_corner.append(side[-i-1][2])
                side[-i-1][2]=new[i]
        else:
            for i in range(3):
                old_corner.append(side[i][2])
                side[i][2]=new[i]
    elif corner==2:#아래 모서리
        if direc==1:#역시계방향
            for i in range(3):
                old_corner.append(side[2][i])
                side[2][i]=new[i]
        else:
            for i in range(3):
                old_corner.append(side[2][-1-i])
                side[2][-1-i]=new[i]
    elif corner==3:#왼쪽 모서리
        if direc==1:#역시계방향
            for i in range(3):
                old_corner.append(side[i][0])
                side[i][0]=new[i]
        else:
            for i in range(3):
                old_corner.append(side[-1-i][0])
                side[-1-i][0]=new[i]
    elif corner==4:#위쪽 모서리
        if direc==1:#역시계방향
            for i in range(3):
                old_corner.append(side[0][-1-i])
                side[0][-1-i]=new[i]
        else:
            for i in range(3):
                old_corner.append(side[0][i])
                side[0][i]=new[i]
    return old_corner

def rotateSide(side,dir):
    if dir==1:
        for i in side:
            i.reverse()
        return list(map(list,zip(*side)))
    else:
        side.reverse()
        return list(map(list,zip(*side)))

def printSide():
    print("\n-----------------------------------------------")
    for i in range(3):
        print(*sides[5][i],end="  ")
        print(*sides[1][i],end="  ")
        print(*sides[6][i])
    print()
    for i in [2,3,4]:
        for j in range(3):
            print("       ",end="")
            print(*sides[i][j])
        print()


role={
    1:[(2,4,1),(5,1,1),(4,2,1),(6,3,1)],
    2:[(3,4,1),(5,2,1),(1,2,1),(6,2,1)],
    3:[(4,4,1),(5,3,1),(2,2,1),(6,1,1)],
    4:[(1,4,1),(5,4,1),(3,2,1),(6,4,1)],
    5:[(2,3,1),(3,3,1),(4,3,1),(1,3,1)],
    6:[(2,1,1),(1,1,1),(4,1,1),(3,1,1)]
}

for _ in range(k):
    dir_match={
        "U":1,
        "D":3,
        "F":2,
        "B":4,
        "L":5,
        "R":6
    }
    sides=[[],
           [["w","w","w"],["w","w","w"],["w","w","w"]],
           [["r","r","r"],["r","r","r"],["r","r","r"]],
           [["y","y","y"],["y","y","y"],["y","y","y"]],
           [["o","o","o"],["o","o","o"],["o","o","o"]],
           [["g","g","g"],["g","g","g"],["g","g","g"]],
           [["b","b","b"],["b","b","b"],["b","b","b"]]]
    oper_num=int(input())
    oper=list(input().split())
    # printSide()
    for j in oper:
        oper_side=j[0]
        oper_dir=j[1]
        temp_new=["X","X","X"]
        if oper_dir=="-":
            reverse_role=role[dir_match[oper_side]]
            for i in range(5):
                side,corner,dir=role[dir_match[oper_side]][(-i)%4]
                if oper_dir=="-":
                    dir=2
                temp_new=swap(corner,dir,temp_new,sides[side])
            sides[dir_match[oper_side]]=rotateSide(sides[dir_match[oper_side]],1)
        else:
            for i in range(5):
                side,corner,dir=role[dir_match[oper_side]][i%4]
                temp_new=swap(corner,dir,temp_new,sides[side])
            sides[dir_match[oper_side]]=rotateSide(sides[dir_match[oper_side]],2)
        # printSide()
    for i in range(3):
        for j in range(3):
            print(sides[1][i][j],end="")
        print()