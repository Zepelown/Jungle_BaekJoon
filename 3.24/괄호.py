stack = []
n = int(input())
for _ in range(n):
    stack.clear()
    s = input()
    for i in s:
        if len(stack) != 0 and stack[len(stack)-1] == '(' and i == ')':
            stack.pop()
            continue
        stack.append(i)

    if len(stack) != 0:
        print('NO')
        continue
    print('YES')

