package in.ril;

/**
 * Created by amit.sharma5 on 08/11/18.
 */
public class CountComponents {

    static int[][] grid = new int[][]{
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1}
    };

    public static void main(String[] args) {
        for(int i=0; i<5;i++){
            for(int j=0;j<5;j++){
                int currentValue = grid[i][j];
                int aValue = grid[i][j+1];
                int bValue = grid[i+1][j];
                int cValue = grid[i+1][j+1];

//                if(currentValue== )

            }
        }
    }
}
