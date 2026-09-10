class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Sudoku solve karne ke liye backtracking
    private boolean solve(char[][] board) {

        // Pura board check karo
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Empty cell mila
                if (board[row][col] == '.') {

                    // 1 se 9 tak number try karo
                    for (char num = '1'; num <= '9'; num++) {

                        // Check karo number valid hai ya nahi
                        if (isValid(board, row, col, num)) {

                            // Number place karo
                            board[row][col] = num;

                            // Aage ka Sudoku solve karne ki try karo
                            if (solve(board)) {
                                return true;
                            }

                            // Agar solution nahi mila,
                            // number ko wapas empty kar do
                            board[row][col] = '.';
                        }
                    }

                    // Koi bhi number valid nahi hua
                    return false;
                }
            }
        }

        // Koi empty cell nahi bacha = Sudoku solved
        return true;
    }

    // Check karta hai ki number place karna valid hai ya nahi
    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            // Same row check
            if (board[row][i] == num) {
                return false;
            }

            // Same column check
            if (board[i][col] == num) {
                return false;
            }

            // Same 3x3 box check
            int boxRow = (row / 3) * 3 + i / 3;
            int boxCol = (col / 3) * 3 + i % 3;

            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }

        return true;
    }
}