class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                result[i][j]=image[i][j];
            }
        }
        dfs(sr,sc,image,isVisited,m,n,color,result);
        return result;
    }

    private void dfs(int row,int col,int[][] image,boolean[][] isVisited,int m,int n,int color,int[][] result)
    {
        result[row][col]=color;
        isVisited[row][col]=true;

        int[] xCor = {-1,0,0,1};
        int[] yCor = {0,-1,1,0};

        for(int k=0;k<4;k++)
        {
            int newRow = xCor[k]+row;
            int newCol = yCor[k]+col;

            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !isVisited[newRow][newCol] && image[row][col]==image[newRow][newCol])
            {
                dfs(newRow,newCol,image,isVisited,m,n,color,result);
            }
        }
    }
}