import sys

input = sys.stdin.readline

n = int(input().strip())
towers = list(map(int, input().strip().split()))

stack = []
result = [0] * n  # 결과를 저장할 리스트 초기화

for i in range(n):
    # 현재 탑보다 낮은 탑은 스택에서 제거
    while stack and towers[stack[-1]] < towers[i]:
        stack.pop()

    # 스택이 비어 있지 않다면, 가장 가까운 왼쪽의 높은 탑의 인덱스를 결과에 저장
    if stack:
        result[i] = stack[-1] + 1  # 0-based index를 1-based로 변환

    # 현재 탑의 인덱스를 스택에 추가
    stack.append(i)

# 결과 출력
print(" ".join(map(str, result)))

# result = []
# prev_index = stack[len(stack)-1]
# for i in range(n,0,-1):
#     pop_index = stack.pop()
#     # 첫 번째 원소 처리
#     if len(stack) == 0:
#         break
#     peek_index = stack[len(stack) - 1]
#     if towers[peek_index] >= towers[pop_index]:
#         for j in range(pop_index, prev_index+1):
#             result.append(pop_index)
#         prev_index = pop_index - 1
#         continue
#
# # 남은 거 처리
# for i in range(prev_index+1):
#     result.append(0)
#
# print(" ".join(map(str, reversed(result))))
