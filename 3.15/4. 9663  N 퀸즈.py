"""
is_promising은 퀸을 놓은 위치가 놓을 수 있는 위치인지 파악하는 함수

과정
1. N-queens가 성립할려면 각 줄마다 퀸이 존재해야 함
2. 같은 열인지 파악(row[x] == row[i]), 같은 대각선인지 파악(abs(row[x] - row[i]) == abs(x - i))
3.

"""

n = int(input())

ans = 0
row = [0] * n


def is_promising(x):
    for i in range(x):
        if row[x] == row[i] or (row[x] + x == row[i] + i) or (abs(row[x] - row[i]) == abs(x - i)):
            return False
    return True

def n_queens(x):
    global ans
    if x == n:
        ans += 1
        return

    for i in range(n):
        # [x, i]에 퀸을 놓겠다.
        row[x] = i
        if is_promising(x):
            n_queens(x + 1)


n_queens(0)
print(ans)