class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {

        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }

        for(int[] e:prerequisites)
        {
            list.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int node = q.poll();
            count++;
            for(int neighbour : list.get(node))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                {
                    q.add(neighbour);
                }
            }
        }

        return count==n;
    }
}