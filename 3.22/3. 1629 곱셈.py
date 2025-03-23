l = list(map(int, input().split()))

a = l[0]
b = l[1]
c = l[2]

arr = {}
arr[1] = a % c
arr[2] = (arr[1] * arr[1]) %c
def search(a, c, b):
    if b == 1:
        return arr[1]
    half = b // 2
    if not half in arr:
        search(a, c, half)
    if not b-half in arr:
        search(a, c, b-half)
    arr[b] = (arr[half] * arr[b-half]) % c
search(a,c,b)
print(arr[b])


