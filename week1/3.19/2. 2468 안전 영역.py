from collections import deque

n = int(input())
directions = { (0, 1), (0, -1), (1, 0), (-1, 0) }
visited = [[False] * n for _ in range(n)]
arr = []
arr_max = 0

for _ in range(n):
    numbers = list(map(int, input().split()))
    arr.append(numbers)
    arr_max = max(arr_max, max(numbers))


def bfs(start_x,start_y, goal):
    global n, directions, visited
    queue = deque()
    queue.append((start_x,start_y))
    visited[start_x][start_y] = True
    while len(queue) != 0:
        current_x, current_y  = queue.popleft()

        for dir in directions:
            next_x = dir[0] + current_x
            next_y = dir[1] + current_y

            if next_x < 0 or next_y <0 or next_x >= n or next_y >= n:
                continue

            if visited[next_x][next_y]:
                continue

            if arr[next_x][next_y] <= goal:
                continue
            queue.append((next_x,next_y))
            visited[next_x][next_y] = True
    return 1

def dfs(start_x,start_y, goal):
    global n, directions, visited
    stack = list()
    stack.append((start_x,start_y))
    visited[start_x][start_y] = True
    while len(stack) != 0:
        current_x, current_y  = stack.pop()

        for dir in directions:
            next_x = dir[0] + current_x
            next_y = dir[1] + current_y

            if next_x < 0 or next_y <0 or next_x >= n or next_y >= n:
                continue

            if visited[next_x][next_y]:
                continue

            if arr[next_x][next_y] <= goal:
                continue
            stack.append((next_x,next_y))
            visited[next_x][next_y] = True
    return 1

def dfs2(current_x, current_y, goal):
    global n, directions, visited

    if current_x < 0 or current_y < 0 or current_x >= n or current_y >= n:
        return

    if visited[current_x][current_y]:
        return

    if arr[current_x][current_y] <= goal:
        return

    visited[current_x][current_y] = True

    for dir in directions:
        next_x = dir[0] + current_x
        next_y = dir[1] + current_y

        dfs2(next_x,next_y,goal)

ret = 0
for threshold in range(arr_max):
    result = 0
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and arr[i][j] > threshold:
                # result += dfs(i, j, threshold)
                dfs2(i,j,threshold)
                result +=1

    ret = max(result, ret)

print(ret)