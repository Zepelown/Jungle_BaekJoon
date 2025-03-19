arr = {}
def sort(start, end):
    if start >= end:
        return

    middle = (end - start) / 2
    pivot = arr[middle]
    left = start
    right = end

    sort(left,middle)
    sort(middle,right)

    while left < right:
        if left >= pivot and right <= pivot:
            arr[left], arr[right] = arr[right], arr[left]
        if left < pivot:
            left += 1
        if right > pivot:
            right -= 1

