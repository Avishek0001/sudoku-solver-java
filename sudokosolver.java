public class sudokosolver {

    public static  boolean isSafe(int[][] board,int row,int col,int n) {
        for(int i=0;i<board.length;i++){
            if(board[i][col]==(n+0)){
                return false;
            }
            if(board[row][i]==(n+0)){
                return false;
        }
    }
    // for grid calculation
        int s = (row/3)*3;
        int s1 = (col/3)*3;
        for(int i = s;i<s+3;i++){
            for(int j = s1;j<s1+3;j++){
                if(board[i][j]==(n+0)){
                    return false;
            }
        }
    }
    return true;
}

    public static boolean helper(int[][] board, int row, int col){
        if(row==board.length){
            return true;
        }
        int newrow = 0;
        int newcol = 0;
        if(col == (board.length-1))
        {
            newrow=row+1;
            newcol=0;
        }
        else{
            newrow=row;
            newcol=col+1;
        }
        if(board[row][col] != 0){
            if(helper(board,newrow,newcol)){
                return true;   
            }
        }
        else
        {
            for(int i=1;i<=9;i++)
            {
                if(isSafe(board,row,col,i))
                    {
                        board[row][col]=(i+0);
                        if(helper(board,newrow,newcol)){
                            return true;
                        }
                        else{
                            board[row][col]=0;
                        }
                    }
                }
            }
        
        return false;
    }

    static void print(int[][] board)
    {
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j <board.length; j++)
                System.out.print(  board[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) 
        
     {
       int[][]board={ { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
       { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
       { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
       { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
       { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
       { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
       { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
       { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
       { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        
      if (helper(board, 0, 0))
      print(board);
  else
      System.out.println("No Solution exists");
        
    }
 
    }

