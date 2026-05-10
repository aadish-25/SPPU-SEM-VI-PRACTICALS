
// n-queen
import java.util.*;

public class A4 {
    static ArrayList<ArrayList<String>> ans = new ArrayList<>();

    static void printSolutions() {
        System.out.println("Total solutions: " + ans.size());
        for (ArrayList<String> config : ans) {
            for (String row : config) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    static boolean isSafe(String board[][], int row, int col, int n) {
        // Check row
        for (int i = 0; i < n; i++) {
            if (board[row][i].equals("Q"))
                return false;
        }
        // Check column
        for (int i = 0; i < n; i++) {
            if (board[i][col].equals("Q"))
                return false;
        }
        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }
        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q"))
                return false;
        }
        return true;
    }

    static void saveBoard(String board[][], int n) {
        ArrayList<String> config = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row = row + board[i][j];
            }
            config.add(row);
        }
        ans.add(config);
    }

    static void nQueens(String board[][], int row, int n) {
        if (row == n) {
            saveBoard(board, n);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = "Q";
                nQueens(board, row + 1, n);
                board[row][j] = ".";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of nxn matrix: ");
        int n = sc.nextInt();

        String board[][] = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }

        nQueens(board, 0, n);
        printSolutions();
        sc.close();
    }
}
