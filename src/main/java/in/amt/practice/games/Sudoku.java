package in.amt.practice.games;

/**
 * Created by amit.sharma5 on 06/11/18.
 */
public class Sudoku {

    public Sudoku() {
    }

    public Sudoku(int[][] grid) {
        this.grid = grid;
    }



    static int size = 9;

    static int[][] grid = new int[size][size];

    public static boolean isPresentInRow(int rowNum, int number){
        for(int i=0; i<size;i++){
            if(grid[rowNum][i]==number){
                return true;
            }
        }
        return false;
    }

    public static boolean isPresentInColumn(int colNum, int number){
        for(int i=0; i<size;i++){
            if(grid[i][colNum]==number){
                return true;
            }
        }
        return false;
    }

    public static boolean isPresentInBox(int rowNum, int colNum, int number){
        int boxStartRowNum = rowNum - rowNum%3;
        int boxStartColNum = colNum - colNum%3;

        for(int i=boxStartRowNum;i<+boxStartRowNum+3;i++){
            for(int j=boxStartColNum;j<=boxStartColNum+3;j++){
                if(grid[i][j]==number){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isOk(int rowNum, int colNum, int number){
        if(isPresentInRow(rowNum,number) || isPresentInColumn(colNum,number) || isPresentInBox(rowNum, colNum, number)){
            return false;
        }
        return true;
    }



    public static int[][] GRID_TO_SOLVE = {
            {9,0,0,1,0,0,0,0,5},
            {0,0,5,0,9,0,2,0,1},
            {8,0,0,0,4,0,0,0,0},
            {0,0,0,0,8,0,0,0,0},
            {0,0,0,7,0,0,0,0,0},
            {0,0,0,0,2,6,0,0,9},
            {2,0,0,3,0,0,0,0,6},
            {0,0,0,2,0,0,9,0,0},
            {0,0,1,9,0,4,5,7,0},
    };

    public static void main(String[] args) {
        System.out.println(5%3);
    }

    public boolean solve() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == 0) {
                    for (int number = 1; number <= size; number++) {
                        if (isOk(row, col, number)) {
                            grid[row][col] = number;

                            if (solve()) {
                                return true;
                            } else {
                                grid[row][col] = 0;
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }
}
