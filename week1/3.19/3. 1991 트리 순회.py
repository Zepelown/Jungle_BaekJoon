tree = {}

n = int(input())
for _ in range(n):
    m = input().split()
    parent = m[0]
    left = m[1]
    right = m[2]
    tree[parent] = (left, right)


def first(current):
    global tree
    if current == '.':
        return
    left, right = tree[current]
    print(current, end='')
    first(left)
    first(right)

def middle(current):
    global tree
    if current == '.':
        return
    left, right = tree[current]

    middle(left)
    print(current, end='')
    middle(right)

def last(current):
    global tree
    if current == '.':
        return
    left, right = tree[current]

    last(left)
    last(right)
    print(current, end='')

first('A')
print()
middle('A')
print()
last('A')