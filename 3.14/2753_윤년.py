import sys

year = int(input())

if year % 4 != 0:
    print(0)
    sys.exit()

if year % 100 == 0 and year % 400 != 0:
    print(0)
else:
    print(1)