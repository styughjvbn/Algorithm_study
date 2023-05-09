import sys

n=int(sys.stdin.readline())

candies=[]
for i in range(n):
    candies.append(list(sys.stdin.readline().strip()))

result=0
for i in range(n):
    for j in range(n-1):
        candies[i][j],candies[i][j+1]=candies[i][j+1],candies[i][j]
        count=1
        base=candies[i][0]
        for k in range(1,n):
            if candies[i][k]==base:
                count+=1
            else:
                result=max(count,result)
                count=1
                base=candies[i][k]
        result=max(count,result)
        count = 1
        base = candies[0][j]
        for k in range(1,n):
            if candies[k][j]==base:
                count+=1
            else:
                result=max(count,result)
                count=1
                base=candies[k][j]
        result = max(count, result)
        count = 1
        base = candies[0][j+1]
        for k in range(1, n):
            if candies[k][j+1] == base:
                count += 1
            else:
                result = max(count, result)
                count = 1
                base = candies[k][j+1]
        result = max(count, result)
        if j+1==n-1:
            count = 1
            base = candies[0][j+1]
            for k in range(1, n):
                if candies[k][j+1] == base:
                    count += 1
                else:
                    result = max(count, result)
                    count = 1
                    base = candies[k][j+1]
            result = max(count, result)
        candies[i][j], candies[i][j + 1] = candies[i][j + 1], candies[i][j]
for i in range(n-1):
    for j in range(n):
        candies[i][j],candies[i+1][j]=candies[i+1][j],candies[i][j]
        count=1
        base=candies[i][0]
        for k in range(1,n):
            if candies[i][k]==base:
                count+=1
            else:
                result=max(count,result)
                count=1
                base=candies[i][k]
        result = max(count, result)
        count = 1
        base = candies[i+1][0]
        for k in range(1, n):
            if candies[i+1][k] == base:
                count += 1
            else:
                result = max(count, result)
                count = 1
                base = candies[i+1][k]
        result = max(count, result)
        count = 1
        base = candies[0][j]
        for k in range(1,n):
            if candies[k][j]==base:
                count+=1
            else:
                result=max(count,result)
                count=1
                base=candies[k][j]
        result = max(count, result)
        if i+1==n-1:
            count = 1
            base = candies[i+1][0]
            for k in range(1, n):
                if candies[i+1][k] == base:
                    count += 1
                else:
                    result = max(count, result)
                    count = 1
                    base = candies[i+1][k]
            result = max(count, result)
        candies[i][j], candies[i + 1][j] = candies[i + 1][j], candies[i][j]

print(result)