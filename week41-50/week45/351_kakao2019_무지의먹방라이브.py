import heapq
def solution(food_times, k):
    answer = -1
    min_time=[]
    for i in enumerate(food_times):
        heapq.heappush(min_time,(i[1],i[0]))
    rotation_count=0
    remain_food=len(food_times)
    while min_time:
        time,idx=heapq.heappop(min_time)
        if k-(time-rotation_count)*remain_food<0:
            print(k)
            k=(k%remain_food)+1
            for index, food in enumerate(food_times):
                if food!=0:
                    k-=1
                    if k<=0:
                        answer=index+1
                        return answer
        else:
            k-=(time-rotation_count)*remain_food
            rotation_count+=time-rotation_count
            remain_food-=1
            food_times[idx]=0
    return answer