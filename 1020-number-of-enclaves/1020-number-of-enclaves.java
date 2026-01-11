class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isPossible = new boolean[m][n];
        int count = 0; 

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0 || i==m-1 || j==0 || j==n-1) && grid[i][j]==1)
                {
                    dfs(i,j,isPossible,grid);
                }
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !isPossible[i][j])
                {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row,int col,boolean[][] isPossible,int[][] grid)
    {
        isPossible[row][col]=true;

        int[] xCor = {1,-1,0,0};
        int[] yCor = {0,0,-1,1};

        for(int k=0;k<4;k++)
        {
            int newRow = row + xCor[k];
            int newCol = col + yCor[k];

            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && !isPossible[newRow][newCol] && grid[newRow][newCol]==1)
            {
                dfs(newRow,newCol,isPossible,grid);
            }
        }
    }
}