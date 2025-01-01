from itertools import combinations
word=list(input().strip())

nums=[i for i in range(len(word))]
case=list(combinations(nums,3))
word_list=[]
for i in case:
    div_word1=word[:i[0]+1]
    div_word2=word[i[0]+1:i[1]+1]
    div_word3=word[i[1]+1:]
    div_word1.reverse()
    div_word2.reverse()
    div_word3.reverse()
    new_word="".join(div_word1+div_word2+div_word3)
    word_list.append(new_word)

word_list.sort()
print(word_list[0])