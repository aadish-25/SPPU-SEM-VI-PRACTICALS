# N-Queen Problem in Python

ans = []


def printSolutions():
    print("Total solutions:", len(ans))

    for config in ans:
        for row in config:
            print(row)
        print()


def isSafe(board, row, col, n):
    # Check column
    for i in range(n):
        if board[i][col] == "Q":
            return False

    # Check left diagonal
    i = row
    j = col

    while i >= 0 and j >= 0:
        if board[i][j] == "Q":
            return False
        i -= 1
        j -= 1

    # Check right diagonal
    i = row
    j = col

    while i >= 0 and j < n:
        if board[i][j] == "Q":
            return False
        i -= 1
        j += 1

    return True


def saveBoard(board, n):
    config = []

    for i in range(n):
        row = ""
        for j in range(n):
            row += board[i][j]
        config.append(row)
    ans.append(config)


def nQueens(board, row, n):

    if row == n:
        saveBoard(board, n)
        return

    for j in range(n):
        if isSafe(board, row, j, n):
            board[row][j] = "Q"
            nQueens(board, row + 1, n)
            board[row][j] = "."


def main():
    n = int(input("Enter the size of nxn matrix: "))

    board = []

    for i in range(n):
        temp = []
        for j in range(n):
            temp.append(".")
        board.append(temp)

    nQueens(board, 0, n)
    printSolutions()


main()
