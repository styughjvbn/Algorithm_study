from collections import deque
n,jimin,hansu=map(int,input().split())
game=[0]*(n)
game[jimin-1]=1
game[hansu-1]=1
game=deque(game)
result=0
flag=False
while True:
    if flag:
        print(result)
        exit()
    result += 1
    new_game = deque()
    while game:
        player1=game.popleft()
        if game:
            player2=game.popleft()
            if player2==1 and player1==1:
                flag=True
                break
            else:
                if player1 or player2:
                    new_game.append(1)
                else:
                    new_game.append(0)
        else:
            if player1:
                new_game.append(1)
            else:
                new_game.append(0)
    game=new_game
