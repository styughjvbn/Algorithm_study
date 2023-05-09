import sys
#간단한 큐 구현
class queue:
    def __init__(self,n):
        self.arr=[0]*(n*2)
        self.front = 0
        self.back = 0
    def push(self,num):
        self.arr[self.back]=num
        self.back+=1
    def pop(self):
        if self.isEmpty()==1:
            return -1
        else:
            temp=self.arr[self.front]
            self.front+=1
            return temp
    def isEmpty(self):
        if self.front==self.back:
            return 1
        else:
            return 0
    def size(self):
        return self.back-self.front
    def front1(self):
        if self.isEmpty() == 1:
            return -1
        else:
            return self.arr[self.front]
    def back1(self):
        if self.isEmpty() == 1:
            return -1
        else:
            return self.arr[self.back-1]

n=int(sys.stdin.readline().strip())
my_queue=queue(n)
for i in range(n):
    my_queue.push(i+1)
while my_queue.size()!=1:
    my_queue.pop()
    my_queue.push(my_queue.pop())

print(my_queue.back1())