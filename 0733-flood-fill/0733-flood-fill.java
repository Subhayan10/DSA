class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] result = new int[m][n];
        boolean[][] isVisited = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                result[i][j]=image[i][j];
            }
        }
        dfs(sr,sc,image,result,isVisited,m,n,color);
        return result;
    }

    public void dfs(int row, int col , int[][] image, int[][] result, boolean[][] isVisited, int m, int n, int color)
    {
        isVisited[row][col]=true;
        result[row][col] = color;
        int[] xCor = {-1,0,0,+1};
        int[] yCor = {0,-1,+1,0};

        for(int k=0;k<4;k++)
        {
            int newRow = row + xCor[k];
            int newCol = col + yCor[k];

            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !isVisited[newRow][newCol] && image[newRow][newCol]==image[row][col])
            {
                dfs(newRow,newCol,image,result,isVisited,m,n,color);
            }
        }
    }
}