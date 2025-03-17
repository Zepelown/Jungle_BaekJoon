n = int(input())
visited_col = set()
result= []
ret = 0
def can_select(row, col):
    global n
    if col in visited_col:
        return False
    if row > n or col > n or row < 1 or col < 1:
        return False
    for (x,y) in result:
        if row - col == (x-y) or col + row == (y+x):
            return False
    return True

def search(row):
    global n,ret
    if row > n:
        ret += 1
        return

    for i in range(1, n + 1):
        if can_select(row,i):
            visited_col.add(i)
            result.append((row, i))
            search(row + 1)
            visited_col.remove(i)
            result.pop()

search(1)
print(ret)

