from collections import deque


def solution(cacheSize, cities):
    answer = 0
    cache = deque()
    num = 0
    if cacheSize == 0:
        answer = len(cities) * 5
    else:
        for i in range(len(cities)):
            if num < cacheSize:
                if cities[i].lower() in cache:
                    cache.remove(cities[i].lower())
                    cache.append(cities[i].lower())
                    answer += 1
                else:
                    cache.append(cities[i].lower())
                    num += 1
                    answer += 5
            else:
                if cities[i].lower() in cache:
                    cache.remove(cities[i].lower())
                    cache.append(cities[i].lower())
                    answer += 1
                else:
                    cache.popleft()
                    cache.append(cities[i].lower())
                    answer += 5

    return answer