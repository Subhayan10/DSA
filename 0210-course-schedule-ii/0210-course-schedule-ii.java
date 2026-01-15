class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;

            for (int next : graph.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}
