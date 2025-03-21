l = list(map(int, input().split()))
n = l[0]
c  = l[1]

arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort()

result = 0

left = 1
right = arr[-1] - arr[0]

while left <= right:
    middle = (left + right) // 2
    cnt = 1
    last_installed = arr[0]
    for i in range(1,n):
        dist = arr[i] - last_installed
        if dist >= middle:
            cnt +=1
            last_installed = arr[i]
    if cnt >= c:
        left = middle+1
        result = max(result, middle)
    elif cnt < c:
        right = middle -1

print(result)