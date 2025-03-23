stack = []


def push(data):
    global stack
    stack.append(data)


def pop():
    global stack
    if len(stack) == 0:
        print(-1)
        return
    print(stack.pop())


def size():
    global stack
    print(len(stack))


def empty():
    global stack
    if len(stack) != 0:
        print(0)
        return
    print(1)


def top():
    global stack
    if len(stack) != 0:
        print(stack[len(stack) - 1])
        return
    print(-1)


t = int(input())
for _ in range(t):
    l = list(input().split())
    if len(l) == 2:
        push(int(l[1]))
        continue

    command = l[0]
    if command == 'top':
        top()
    elif command == 'size':
        size()
    elif command == 'empty':
        empty()
    elif command == 'pop':
        pop()
