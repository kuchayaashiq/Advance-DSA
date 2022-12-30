package Backtracking.Recursion;

public class FloodFill {
    public static void main(String[] args) {
        int[][] mat = {{0,1,0,1,1,1 },{0,1,0,1,1,0},{0,1,0,0,0,0},{0,0,0,1,1,0},{0,1,0,1,1,0},{0,0,0,1,1,0}};
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        floodFill(0, 0, mat, n, m,"", visited);
    }

    private static void floodFill(int i, int j, int[][] mat, int n, int m, String psf, boolean[][] visited) {
        if(i<0 || j <0 || i >=n || j >= m ||mat[i][j] ==1 || visited[i][j]){
            return;
        }
        if(i == n-1 && j== m-1){
            System.out.println(psf);
            return;
        }
        visited[i][j] = true;
        //up
        floodFill(i-1, j, mat, n, m, psf+"t",visited);
        //left
        floodFill(i, j-1, mat, n, m, psf+"l",visited);
        //down
        floodFill(i+1, j, mat, n, m, psf+"d",visited);
        //right
        floodFill(i, j+1, mat, n, m, psf+"r",visited);
        visited[i][j] = false;
    }
}
