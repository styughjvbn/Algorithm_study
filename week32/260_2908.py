a,b=map(list,input().strip().split())
a.reverse()
b.reverse()
print(max(int("".join(a)),int("".join(b))))