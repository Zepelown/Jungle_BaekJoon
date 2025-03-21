from typing import MutableSequence


def lis_binary_search(arr : MutableSequence):
    lis = []  # LIS 배열 초기화
    for num in arr:
        pos = binary_search(lis, num)
        if pos == len(lis):
            lis.append(num)  # num이 가장 크다면 추가
        else:
            lis[pos] = num  # num으로 기존 값을 교체
    return len(lis)

def binary_search(lst : MutableSequence, data):
    left = 0
    right = len(lst)
    while left < right:
        middle = (left + right) // 2
        if lst[middle] < data:
            left = middle + 1
        else:
            right = middle
    return left

n = int(input())
arr = list(map(int, input().split()))

# 결과 출력
print(lis_binary_search(arr))
