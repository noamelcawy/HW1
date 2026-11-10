public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }

        int n = m.length;
        
        int[] dist = new int[n];
        for (int v = 0; v < n; v++) {
            dist[v] = -1;
        }
        
        dist[i] = 0;

        for (int step = 0; step < n; step++) {
            
            for (int u = 0; u < n; u++) {
                
                if (dist[u] == step) {
                    
                    for (int v = 0; v < n; v++) {
                        
                        if (m[u][v] == 1 && dist[v] == -1) {
                            dist[v] = step + 1; 
                            
                            if (v == j) {
                                return dist[v];
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}