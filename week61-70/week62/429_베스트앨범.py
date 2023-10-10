def solution(genres, plays):
    answer = []
    play_per_genres={}
    for idx,i in enumerate(zip(genres,plays)):
        if play_per_genres.get(i[0]):
            play_per_genres[i[0]]['total']-=i[1]
            play_per_genres[i[0]]['plays'].append((-i[1],idx))
        else:
            play_per_genres[i[0]]={
                "plays":[(-i[1],idx)],
                "total":-i[1]
            }
    for i in play_per_genres.keys():
        play_per_genres[i]['plays'].sort()
    temp_answer=sorted(play_per_genres.items(),key=lambda a:a[1]["total"])

    for i in temp_answer:
        count=0
        for j in i[1]["plays"]:
            count+=1
            if count>2:
                break
            answer.append(j[1])
    print(answer)

    return answer