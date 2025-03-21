l = list(map(int, input().split()))
n = l[0]
m = l[1]

arr = list(map(int, input().split()))
arr.sort(reverse=True)

def calculate_stick_length(height):
    res = 0
    for i in arr:
        if i <= height:
            continue
        res += i - height
    return res

left = 0
right = arr[0]
result = 0

while left <= right:
    middle = (left + right) // 2
    temp = calculate_stick_length(middle)
    if temp < m:
        right = middle -1
    else:
        result = max(result, middle)
        left = middle+1

print(result)