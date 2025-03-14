t = int(input())

for _ in range(t):
    s = input().split()
    count = int(s[0])
    for i in s[1]:
        print(i * count, end='')
    print()
# 줄바꿈이 반드시 필요!
