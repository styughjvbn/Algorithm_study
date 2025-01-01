def solution(s):
    answer = True

    stack=[]
    for i in s:
        if i==")":
            if len(stack)>0 and stack[-1]=="(":
                stack.pop()
            else:
                return False
        else:
            stack.append("(")
    if len(stack)>0:
        return False

    return True