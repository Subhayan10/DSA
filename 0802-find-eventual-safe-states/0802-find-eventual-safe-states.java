class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int[] state = new int[graph.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, state)) {  
                list.add(i);
            }
        }

        return list;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {

        if (state[node] != 0) {
            return state[node] == 2;  
        }

        state[node] = 1;  

        for (int neigh : graph[node]) {
            if (!dfs(neigh, graph, state)) {  
                return false;
            }
        }

        state[node] = 2; // safe
        return true;
    }
}
