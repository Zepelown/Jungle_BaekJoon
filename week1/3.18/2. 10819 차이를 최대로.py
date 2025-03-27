from typing import MutableSequence

n = int(input())
arr = list(map(int, input().split()))
visited = [False] * n
ret = -1

def search(result : MutableSequence):
    global n, ret
    if len(result) == n:
        #길이 체크
        ret = max(ret, calculate(result))
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            result.append(arr[i])
            search(result)
            visited[i] = False
            result.pop()

def calculate(arr: MutableSequence):
    global n
    result = 0
    for i in range(n-1):
        result += abs(arr[i]-arr[i+1])
    return result

search([]) # 빈 값을 넣어야 한다
print(ret)
