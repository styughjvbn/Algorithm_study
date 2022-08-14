import sys
#이분탐색을 활용한 LIS
n=int(sys.stdin.readline().strip())
arr=list(map(int,sys.stdin.readline().split()))


temp=[arr[0]]

for i in range(1,n):
    if temp[-1]<arr[i]:
        temp.append(arr[i])
    elif temp[-1]>arr[i]:
        high = len(temp) - 1
        low = 0
        mid=0
        while low<=high:
            mid=(high+low)//2
            if temp[mid]>=arr[i]:
                high=mid-1
            else:
                low=mid+1
        temp[low]=arr[i]

print(len(temp))
