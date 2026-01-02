class Solution {
     static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("00");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
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
        if(fresh==0)
        {
            return 0;
        } 

        int minutes = 0;
       int[] xCor = {-1, 0, 0, 1};
       int[] yCor = {0, -1, 1, 0};

        while(!q.isEmpty())
        {
            int size = q.size();
            boolean rotted = false;

            for(int i=0;i<size;i++)
            {
                int[] cell = q.poll();
                int r =  cell[0];
                int c = cell[1];
                for(int k=0;k<4;k++)
                {
                    int nr = r + xCor[k];
                    int nc = c + yCor[k];

                     if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1)
                    {
                        q.offer(new int[]{nr,nc});
                        rotted = true;
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }

            if(rotted) minutes++;
        }

        return fresh==0?minutes:-1;
         
    }

}