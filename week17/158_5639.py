import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
temp=(input())
preorder=[]
i=0
while temp!="\n":
    try:
        preorder.append(int(temp))
        temp=input()
        i+=1
    except:
        break

def postorder(start,end):
    if end<start:
        return
    if end==start:
        print(preorder[start])
    else:
        index=end+1
        for i in range(start,end+1):
            if preorder[start] < preorder[i]:
                index = i
                break
        postorder(start+1,index-1)
        postorder(index, end)
        print(preorder[start])

postorder(0,len(preorder)-1)