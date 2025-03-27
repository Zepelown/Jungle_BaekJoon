from collections.abc import MutableSequence


def bubble_sort(N, arr : MutableSequence):
    for i in range(N - 1, -1, -1):
        for j in range(i-1,-1,-1):
            if arr[i] < arr[j]:
                temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
    return arr

n = int(input())
ar = list()
for _ in range(n):
    ar.append(int(input()))
bubble_sort(n,ar)
for i in ar:
    print(i)

