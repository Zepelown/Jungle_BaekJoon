from typing import MutableSequence
import random
import sys

def quick_sort(arr : MutableSequence, start, end):
    left = start
    right = end
    pivot_idx = random.randint(start, end)
    pivot = arr[pivot_idx]
    while left <= right:
        while arr[left] < pivot:
            left += 1
        while arr[right] > pivot:
            right -= 1
        if left <= right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -=1

    if start < right:
        quick_sort(arr,start,right)
    if left < end:
        quick_sort(arr,left,end)
    return

n = int(sys.stdin.readline())
ar = list()
for _ in range(n):
    ar.append(int(sys.stdin.readline()))

quick_sort(ar,0,n-1)
for i in ar:
    print(i)