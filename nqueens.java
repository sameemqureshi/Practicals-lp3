package NQueens;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class nqueens {
    public static void main(String[] args) {
        int n=8;
        boolean[][]board=new boolean[n][n];
        queens(board,0);

    }
    static int queens(boolean[][] board, int row){
        if(row==board.length){
            display(board);
            return 1;
        }
        int count=0;
        for(int col=0;col< board.length;col++){
            if(issafe(board,row,col)){
                board[row][col]=true;
                count+=queens(board,row+1);
                board[row][col]=false;


            }
            }
        return count;


    }
static boolean issafe(boolean[][] board,int row, int col){
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }


        int maxleft=Math.min(row,col);
        for(int i=1;i<maxleft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        int maxright=Math.min(row,board.length-col-1);
        for(int i=0;i<=maxright;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }return true  ;
}
    public static  void display(boolean[][] board){
        for(boolean[]row:board){
            for(boolean element:row){
                if(element){
                    System.out.println("Q ");
                }else{
                    System.out.println("X ");
                }
            }

      }System.out.println();
    }
}
