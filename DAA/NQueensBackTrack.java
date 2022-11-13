import java.util.Scanner;

public class NQueensBackTrack {

    public static void printNQueens(int chess[][] , String qsf , int row){
        if(row == chess.length){
            System.out.println(qsf);
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if(IsItSafe(chess, row, col)){
                chess[row][col] = 1;
                printNQueens(chess,qsf+row+"-"+col+",",row+1);
                chess[row][col] = 0;
            }
        }
    }
    public static boolean IsItSafe(int[][] chess, int row, int col){
        for (int i = row-1,j=col; i >=0 ; i--) { //Checking vertically (Same column)
            if(chess[i][j] == 1){
                return false;
            }
        }
        for (int i = row-1,j=col-1; i >=0 && j>=0 ; i--,j--) { // Checking Left Upper Diagonal
            if(chess[i][j] == 1){
                return false;
            }
        }
        for (int i = row-1,j=col+1; i >=0 && j< chess.length ; i--,j++) {
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of queens : ");
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        long startTime = System.currentTimeMillis();
        printNQueens(chess,"",0);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime-startTime;
        System.out.println("Time taken : "+totalTime);
    }
}