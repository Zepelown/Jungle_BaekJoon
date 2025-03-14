t = int(input())

for i in range(t):
    line = list(map(int,input().split()))
    scores = list()
    for j in range(1,len(line)):
        scores.append(line[j])
    average = sum(scores) / len(scores)

    member = 0
    for j in scores:
        if j > average:
            member += 1
    percentage = (member / len(scores)) * 100
    print(f"{percentage:.3f}%")

