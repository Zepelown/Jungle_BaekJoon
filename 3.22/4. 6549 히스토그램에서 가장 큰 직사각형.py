def largest_rectangle(histogram):
    stack = []  # 스택에는 인덱스를 저장합니다.
    max_area = 0  # 최대 넓이를 저장할 변수
    n = len(histogram)

    for i in range(n):
        # 현재 높이가 스택의 최상단 높이보다 작으면 넓이를 계산합니다.
        while stack and histogram[stack[-1]] > histogram[i]:
            height = histogram[stack.pop()]  # 스택에서 꺼낸 높이
            width = i if not stack else i - stack[-1] - 1  # 너비 계산
            max_area = max(max_area, height * width)  # 최대 넓이 갱신

        stack.append(i)  # 현재 인덱스를 스택에 추가

    # 히스토그램 끝까지 처리한 후, 스택에 남아 있는 값들 처리
    while stack:
        height = histogram[stack.pop()]  # 스택에서 꺼낸 높이
        width = n if not stack else n - stack[-1] - 1  # 너비 계산
        max_area = max(max_area, height * width)  # 최대 넓이 갱신

    return max_area

while True:
    l = list(map(int, input().split()))
    if l[0] == 0:
        break
    print(largest_rectangle(l[1:]))
