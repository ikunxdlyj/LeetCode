public class CountSquares {
    public int countSquares(int[][] matrix) {
        int[][] prefixArr = buildPrefixArray(matrix);
        int cnt = 0;

        //           (a-1,b-1)             (a-1,b+len-1)
        //                      (a,b)      (a,b+len-1)
        //       (a+len-1,b-1)  (a+len-1,b)(a+len-1,b+len-1)
        for (int a = 0; a < matrix.length; a++) {
            for (int b = 0; b < matrix[0].length; b++) {
                for (int len = 1; a + len - 1 < matrix.length && b + len - 1 < matrix[0].length; len++) {
                    int sum = prefixArr[a + len - 1][b + len - 1]
                            - (b - 1 >= 0 ? prefixArr[a + len - 1][b - 1] : 0)
                            - (a - 1 >= 0 ? prefixArr[a - 1][b + len - 1] : 0)
                            + (a - 1 >= 0 && b - 1 >= 0 ? prefixArr[a - 1][b - 1] : 0);
                    cnt += sum == len * len ? 1 : 0;
                }
            }
        }
        return cnt;
    }

    public int[][] buildPrefixArray(int[][] matrix) {
        int[][] prefixArray = new int[matrix.length][matrix[0].length];
        prefixArray[0][0] = matrix[0][0];
        for (int j = 1; j < matrix[0].length; j++) {
            prefixArray[0][j] = prefixArray[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < matrix.length; i++) {
            prefixArray[i][0] = prefixArray[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                prefixArray[i][j] = matrix[i][j] + prefixArray[i - 1][j] + prefixArray[i][j - 1] - prefixArray[i - 1][j - 1];
            }
        }
        return prefixArray;
    }
}
