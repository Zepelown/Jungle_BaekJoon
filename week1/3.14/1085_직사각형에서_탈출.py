input_values = input().split()

x = int(input_values[0])
y = int(input_values[1])
w = int(input_values[2])
h = int(input_values[3])

left = x
right = w - x
up = h - y
down = y

print(min(left, right, up, down))
