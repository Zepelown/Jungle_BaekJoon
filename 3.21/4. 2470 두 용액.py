n = int(input())
arr = list(map(int,input().split()))

arr.sort()

pl = 0
pr = n-1

result_nums = []
best_sum = 10000000000

# 끝점 두 개가 음수
if arr[pl] <= 0 and arr[pr] <= 0:
    print(f"{arr[pr-1]} {arr[pr]}")
# 끝점 두 개가 양수
elif arr[pl] > 0 and arr[pr] > 0 :
    print(f"{arr[pl]} {arr[pl+1]}")
# 끝점 두 개가 서로 혼합
else :
    while pl < pr:
        num_sum = arr[pl] + arr[pr]

        # 현재 합이 더 작다면 갱신
        if abs(num_sum) < abs(best_sum):
            best_sum = num_sum
            result = (arr[pl], arr[pr])

        # 합이 음수면 왼쪽 포인터 이동 (더 큰 값 선택)
        if num_sum < 0:
            pl += 1
        # 합이 양수면 오른쪽 포인터 이동 (더 작은 값 선택)
        elif num_sum > 0:
            pr -= 1
        # 합이 정확히 0이라면 최적이므로 종료
        else:
            break
    print(f"{result[0]} {result[1]}")