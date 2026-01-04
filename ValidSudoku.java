import java.util.HashSet;
import java.util.Set;

/*
Approach:
- Traverse the board once.
- For each filled cell, create unique keys for row, column, and 3x3 box.
- Use a HashSet to detect duplicates; if a key already exists, Sudoku is invalid.

Time Complexity: O(1) (fixed 9x9 board)
Space Complexity: O(1) (bounded HashSet size)
*/

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        int m = 9;
        int n = 9;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char current = board[i][j];

                if (current == '.')
                    continue;

                String rowKey = current + "_in_row_" + i;
                String columnKey = current + "_in_column_" + j;
                String boxKey = current + "_in_box_" + i / 3 + "_" + j / 3;

                if (!set.add(rowKey) || !set.add(columnKey) || !set.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}
