"""
자르는 순서는 정해져 있지 않다!!
이게 포인트다.
8, 3, 7
이런 식으로 입력이 들어오면 명확히 크기를 구할 수가 없어진다.
또는 매우 복잡해진다.

순서가 중요하지 않으므로 정렬을 다 때리고 모든 조각의 크기를 구하면 그만인 것이다.
그 중 최대를 찾으면 정답!

"""

rectangle = list(map(int,input().split()))
w = rectangle[0]
h = rectangle[1]

width = [0,w]
height = [0,h]


t = int(input())
for _ in range(t):
    a,b = map(int, input().split())
    if a == 0:
        height.append(b)
    elif a == 1:
        width.append(b)

result = 0

height.sort()
width.sort()

for i in range(len(width)-1):
    for j in range(len(height)-1):
        x = width[i+1] - width[i]
        y = height[j+1] - height[j]
        result = max(result, x*y)

print(result)



