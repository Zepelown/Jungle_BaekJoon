"""
size = 한 변 길이
row = 찾고자 하는 행
col = 찾고자 하는 열
address = 위치값 (분할하는 단계에서 계속해서 값이 바뀌므로 이를 추적해야 한다)
각 사분면의 시작점은 그 크기만큼 값을 가진다.
"""

import math

result = 0
def search(size, row, col, address):
    global result
    if size == 1:
        result = address
        return
    middle = size//2
    # 1사분면
    if row < middle and col < middle:
        search(middle, row, col, address)
    # 2사분면
    if row < middle <= col:
        search(middle,row,col-middle,address + middle * middle)
    # 3사분면
    if col < middle <= row:
        search(middle,row-middle,col,address + middle * middle * 2)
    # 4사분면
    if row >= middle and col >= middle:
        search(middle,row-middle,col-middle,address + middle * middle * 3)

n,r,c = list(map(int,input().split()))
s = math.pow(2,n)

search(s,r,c,0)
print(round(result))

