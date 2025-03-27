from collections.abc import MutableSequence

arr = list()
MAX = 7
for _ in range(9):
    arr.append(int(input()))

arr.sort()
done = False

def search(result : MutableSequence, index):
    global done
    if len(result) == MAX:
        if sum(result) == 100 and done == False:
            for num in result:
                print(num)
            done = True
        return

    for i in range(index,9):
        result.append(arr[i])
        search(result,i+1)
        result.pop()

search(list(),0)




