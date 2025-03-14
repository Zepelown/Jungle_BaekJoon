t = int(input())
for i in range(t):
    results = input().split('X')
    score = 0
    for j in results:
        for k in range(1,len(j)+1):
            score += k
    print(score)