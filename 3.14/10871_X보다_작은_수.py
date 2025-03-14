input1 = input().split()

n = int(input1[0])
x = int(input1[1])

input2 = map(int,input().split())

for i in input2:
    if i < x:
        print(f"{i} ", end='')


