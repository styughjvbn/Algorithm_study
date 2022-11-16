import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

n=int(input())
inorder=list(map(int,input().split()))
index_arr=[0]*(n)
for i in range(n):
    index_arr[inorder[i]-1]=i
postorder=list(map(int,input().split()))

def preorder(in_start,in_end,post_start,post_end):
    if in_end==in_start:
        print(inorder[in_end],end=" ")
    else:
        print(postorder[post_end],end=" ")
        index=index_arr[postorder[post_end]-1]
        if (post_start+(index-1-in_start))-post_start>=0:
            preorder(in_start,index-1,post_start,post_start+(index-1-in_start))
        if post_end-1-(post_start+(index-in_start))>=0:
            preorder(index+1, in_end,post_start+(index-in_start),post_end-1)

preorder(0,len(inorder)-1,0,len(postorder)-1)