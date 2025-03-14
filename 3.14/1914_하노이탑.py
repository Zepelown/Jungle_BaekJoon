"""
이 문제의 접근은 다음과 같다.
결국은 재귀적 접근으로 보면 N-1개를 빈 곳으로 옮긴다.
맨 밑에 있던 남은 한 개를 목적지로 옮긴다.
그리고 빈 곳으로 옮겨두었던 N-1개를 목적지로 옮긴다.

파라미터를 중점으로 생각하면 이해가 쉽다.
그냥 보면 empty_loc의 의미가 수시로 달라지는데 함수 정의의 파라미터에선 가지 않아야할 곳을 의미한다.
마찬가지로 start_loc는 어쨌든 시작점이다.
goal_loc를 어쨌든 도착점이다.

"""

result = 0

def search(n, start_loc, goal_loc, empty_loc):
    global result
    if n == 1:
        result += 1
        print(f"{start_loc} -> {goal_loc}")
        return

    search(n - 1, start_loc, empty_loc, goal_loc)
    search(1, start_loc, goal_loc, empty_loc)
    search(n-1,empty_loc,goal_loc,start_loc)

search(3, 1, 3,2)
print(result)