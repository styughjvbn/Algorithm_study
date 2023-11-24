

def solution(places):
    answer = []
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    for x in range(5):
        place=places[x]
        is_check=1
        for i in range(5):
            for j in range(5):
                if place[i][j]=='P':
                    for k in range(4):
                        ni=i+di[k]
                        nj=j+dj[k]
                        if 0<=ni<5 and 0<=nj<5 and place[ni][nj]!='X':
                            if place[ni][nj]=='P':
                                is_check=0
                            for kk in range(4):
                                nni=ni+di[kk]
                                nnj=nj+dj[kk]
                                if 0<=nni<5 and 0<=nnj<5 and not (nni== i and nnj==j) and place[nni][nnj]=='P':
                                    is_check=0
                                    print(i,j)
        answer.append(is_check)

    return answer