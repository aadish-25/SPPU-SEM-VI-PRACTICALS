# A-star
import heapq

goal = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]


def heuristic(state):
    h = 0
    for i in range(3):
        for j in range(3):
            if state[i][j] != 0 and state[i][j] != goal[i][j]:
                h += 1
    return h


def state_to_tuple(state):
    return tuple(tuple(row) for row in state)


def find_blank(state):
    for i in range(3):
        for j in range(3):
            if state[i][j] == 0:
                return i, j


def print_state(state):
    for row in state:
        print(row)
    print()


def get_neighbours(state):
    neighbours = []

    x, y = find_blank(state)

    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    for dx, dy in moves:
        new_x = x + dx
        new_y = y + dy

        if 0 <= new_x < 3 and 0 <= new_y < 3:
            new_state = [row[:] for row in state]

            new_state[x][y], new_state[new_x][new_y] = (
                new_state[new_x][new_y],
                new_state[x][y],
            )

            neighbours.append(new_state)

    return neighbours


def a_star(start):
    pq = []

    g = 0
    h = heuristic(start)
    f = g + h

    heapq.heappush(pq, (f, g, start, []))

    visited = set()

    while pq:
        f, g, current, path = heapq.heappop(pq)

        current_tuple = state_to_tuple(current)

        if current_tuple in visited:
            continue

        visited.add(current_tuple)

        new_path = path + [current]

        if current == goal:
            print("Solution found!\n")

            for step in new_path:
                print_state(step)

            print("Total moves:", g)
            return

        for neighbour in get_neighbours(current):
            neighbour_tuple = state_to_tuple(neighbour)

            if neighbour_tuple not in visited:
                new_g = g + 1
                new_h = heuristic(neighbour)
                new_f = new_g + new_h

                heapq.heappush(pq, (new_f, new_g, neighbour, new_path))

    print("No solution found.")


start = []

print("Enter initial state, use 0 for blank:")

for i in range(3):
    row = list(map(int, input().split()))
    start.append(row)

a_star(start)
