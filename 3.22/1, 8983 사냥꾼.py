from typing import MutableSequence

class Animal_Position:
    def __init__(self, x, y, visited):
        self.x = x
        self.y = y
        self.visited = visited

    def __str__(self):
        return f"Animal_Position(x={self.x}, y={self.y}, visited={self.visited})"

    def __repr__(self):
        return f"Animal_Position(x={self.x}, y={self.y}, visited={self.visited})"

def calculate_include(length, shooters_pos : MutableSequence, animals_pos):
    nearest_shooter_index = binary_search(shooters_pos, animals_pos)
    left_dist = abs(shooters_pos[nearest_shooter_index-1] - animals_pos.x) + animals_pos.y
    if nearest_shooter_index == len(shooters_pos):
        if left_dist <= length:
            animals_pos.visited = True
            return
    right_dist = abs(shooters_pos[nearest_shooter_index] - animals_pos.x) + animals_pos.y
    if left_dist <= length or right_dist <= length:
        animals_pos.visited = True


def binary_search(shooters_pos : MutableSequence, animal_pos):
    left, right = 0, len(shooters_pos)
    while left < right:
        middle = (left + right) // 2
        if animal_pos.x < shooters_pos[middle]:
            right = middle
        else:
            left = middle+1
    return left

s = list(map(int, input().split()))
m = s[0]
n = s[1]
l = s[2]
animals = []

shooters = list(map(int, input().split()))
shooters.sort()

for _ in range(n):
    list1 = list(map(int, input().split()))
    x = list1[0]
    y = list1[1]
    animals.append(Animal_Position(x,y,False))

animals.sort(key=lambda animal: (animal.x, animal.y))

for i in animals:
    calculate_include(l,shooters,i)

result = 0
for i in animals:
    if i.visited:
        result+=1
print(result)
# print(animals)