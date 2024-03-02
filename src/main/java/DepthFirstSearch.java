import java.util.Stack;

public class DepthFirstSearch {

    // Main method. Used for visualising and debugging purposes.
    public static void main(String[] args) {

        int[][] graph1 = {
                {6,9},
                {11},
                {6,7},
                {9},
                {5,8},
                {4,7},
                {0,2,11},
                {2,5},
                {4,10},
                {0,3},
                {8},
                {1,6}
        };

        int[][] graph2 = {
                {3,6,5,9},
                {11},
                {7,10},
                {0},
                {5},
                {0,4,7},
                {0,11},
                {2,5,8},
                {7},
                {0},
                {2},
                {1,6}
        };
        int[] path_graph_1 = depthFirstSearch(graph1);
        int[] path_graph_2 = depthFirstSearch(graph2);

        printPath(path_graph_1);
        printPath(path_graph_2);

    }

    public static int[] depthFirstSearch(int[][] graph) {

        int startNode = 0;
        // Create a stack.
        Stack<Integer> stack = new Stack<>();

        // Create an array called visited. This will keep track of which nodes we have visited.
        boolean[] visited = new boolean[graph.length];

        // Create an array called path. This will keep track of the order of nodes that we visit.
        int[] path = new int[graph.length];

        // Create an index for the path array.
        int pathIndex = 0;

        // Push our starting node to the stack. We can begin our traversal from any valid node. Let's begin our traversal at node 0.
        stack.push(startNode);

        // Record the starting node as visited.
        visited[startNode] = true;

        // While our stack is not empty i.e. while we still have nodes to explore ...
        while(!stack.isEmpty()) {
            // Pop the node that we are currently visiting from the stack.
            int currentNode = stack.pop();

            // Add the node that we are currently visiting to the path.
            path[pathIndex++] = currentNode;

            // Obtain an array of all neighbouring/adjacent nodes of the node that we are currently visiting.
            int[] neighbors = graph[currentNode];

            // For each neighbouring/adjacent node ...
            for(int neighbor : neighbors) {

                // If the neighbouring/adjacent node has not been visited ...
                if(!visited[neighbor]) {

                    // Record the neighbouring/adjacent node as visited.
                    visited[neighbor] = true;

                    // Push the neighbouring/adjacent node onto the stack.
                    stack.push(neighbor);
                }
            }
        }
        // Return the path.
        return path;

    }

    // A private helper method that prints the path. Used for visualisation and debugging purposes.
    private static void printPath(int[] path) {

        for (int node: path) System.out.print(node + " ");
        System.out.println();

    }


}
