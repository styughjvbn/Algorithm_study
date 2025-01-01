def solution(p):
    answer = func(p)
    return answer

def func(string):
    if string=="":
        return ""
    else:
        left=0
        right=0
        if string[0]=="(":
            left+=1
        else:
            right+=1
        slice_idx=1
        for i in range(1,len(string)):
            if left==right:
                break
            else:
                slice_idx+=1
                if string[i]=="(":
                    left+=1
                else:
                    right+=1
        u=string[:slice_idx]
        v=string[slice_idx:]
        if check_pair(u):
            return u+func(v)
        else:
            empty_string="("
            empty_string+=func(v)
            empty_string+=")"
            u=u[1:-1]
            new_u=""
            for i in u:
                if i==")":
                    new_u+="("
                else:
                    new_u+=")"
            empty_string+=new_u
            return empty_string

def check_pair(string):
    stack=[]
    for i in string:
        if i=="(":
            stack.append(i)
        else:
            try:
                if stack[-1]!="(":
                    return False
                else:
                    stack.pop()
            except:
                return False
    else:
         return True