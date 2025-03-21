n = int(input())
arr = list(map(int, input().split()))
arr.sort()

def binary_search(goal):
    global arr, n
    left = 0
    right = n - 1
    while left <= right:
        middle = (left + right) // 2

        if arr[middle] == goal:
            return 1
        elif arr[middle] < goal:
            left = middle + 1
        else:
            right = middle - 1

    return 0

m = int(input())
numbers = list(map(int, input().split()))

for i in numbers:
    print(binary_search(i))



