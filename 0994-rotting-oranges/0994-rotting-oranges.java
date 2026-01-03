class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int[] xCor = {-1,0,0,1};
        int[] yCor = {0,-1,1,0};
        while(!q.isEmpty())
        {
            boolean rotted = false;
            int size = q.size();
            for(int i=0;i<size;i++)
            {

                int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            
            
            for(int k=0;k<4;k++)
            {
                int newRow = xCor[k]+r;
                int newCol = yCor[k]+c;

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1 )
                {
                    grid[newRow][newCol]=2;
                    fresh--;
                    q.offer(new int[]{newRow,newCol});
                    rotted = true;
                }
            }
            }
            if(rotted) minutes++;
        }

        return (fresh==0)?minutes:-1;
    }
}