import math
import sys
import heapq

n, k = map(int, sys.stdin.readline().split())

def dijkstra(start):
    distance = [math.inf] * (100001)
    distance[start] = 0
    heap = []
    heapq.heappush(heap,(0,start))

    while len(heap):
        dis,vertex=heapq.heappop(heap)
        if distance[vertex]<dis:#이미 더 짧은 길이의 경로가 나왔기때문에 힙에 들어온 경로는 폐기
            continue
        else:
            if vertex+1<100001:
                new_dis=dis+1
                if new_dis<distance[vertex+1]:
                    distance[vertex+1]=new_dis
                    heapq.heappush(heap,(new_dis,vertex+1))
            if vertex-1>-1:
                new_dis=dis+1
                if new_dis<distance[vertex-1]:
                    distance[vertex-1]=new_dis
                    heapq.heappush(heap,(new_dis,vertex-1))
            if vertex*2<100001:
                new_dis=dis
                if new_dis<distance[vertex*2]:
                    distance[vertex*2]=new_dis
                    heapq.heappush(heap,(new_dis,vertex*2))
    return distance

print(dijkstra(n)[k])

