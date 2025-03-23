n = int(input())
arr = []
for i in range(n):
    l = list(map(int, input().split()))
    arr.append(l)
result = [0] * 2

def search(size, start_x,start_y):
    global arr, n
    half = size // 2
    color = arr[start_x][start_y]
    not_all_color_flag = False
    for i in range(start_x,start_x+size):
        for j in range(start_y, start_y+size):
            if color != arr[i][j]:
                not_all_color_flag = True
                break

    if not_all_color_flag:
        search(half,start_x,start_y)
        search(half, start_x, start_y + half)
        search(half,start_x+half,start_y)
        search(half,start_x+half, start_y+half)
    else :
        result[color] += 1

search(n,0,0)
print(result[0])
print(result[1])
