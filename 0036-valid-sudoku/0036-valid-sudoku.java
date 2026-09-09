class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Rows ke liye: row[i][number]
        boolean[][] row = new boolean[9][9];

        // Columns ke liye
        boolean[][] col = new boolean[9][9];

        // 3x3 boxes ke liye
        boolean[][] box = new boolean[9][9];

        // Pura Sudoku traverse karo
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Empty cell ko ignore karo
                if (board[i][j] == '.') {
                    continue;
                }

                // Character ko 0-8 index me convert karo
                int num = board[i][j] - '1';

                // Current 3x3 box ka number
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Agar number row, column ya box me already hai
                if (row[i][num] || col[j][num] || box[boxIndex][num]) {
                    return false;
                }

                // Number ko mark kar do
                row[i][num] = true;
                col[j][num] = true;
                box[boxIndex][num] = true;
            }
        }

        // Koi duplicate nahi mila
        return true;
    }
}