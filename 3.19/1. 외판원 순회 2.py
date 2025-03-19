

n = int(input())
arr = []
visited = [False] * n
result =  1000000000

for i in range(n):
    costs = list(map(int, input().split()))
    arr.append(costs)

def search(start, cost, visited_count):
    global result
    if visited_count == n:
        if arr[start][0] != 0 :
            cost += arr[start][0]
            result = min(result, cost)
        return
    if cost >= result:
        return

    for i in range(n):
        goal_cost = arr[start][i]
        if goal_cost != 0 and not visited[i]:
            visited[i] = True
            search(i, cost + goal_cost, visited_count + 1)
            visited[i] = False

visited[0] = True
search(0,0,1)
print(result)