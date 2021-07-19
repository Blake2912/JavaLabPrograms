import java.util.Scanner;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("The dijkstra's algorithm implementation");
        System.out.println("Enter the number of nodes:");
        int n;
        n = input.nextInt();
        int i,j;
        int[][] graph = new int[n][n];
        int[] visited = new int[n];
        int[] d =  new int[n];
        int[] parent = new int[n];
        System.out.println("Enter the cost adjacency matrix:");
        for(i=0;i<n;i++){
            for (j=0;j<n;j++){
                graph[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter the source vertex:");
        int source = input.nextInt();
        for(i=0;i<n;i++){
            visited[i] = 0;
            d[i] = 999;
            parent[i] = 0;
        }
        visited[source] = 1;
        parent[source] = source;
        d[source] = 0;
        int u = source;
        for(int count =0;count<n-1;count++){
            int min = 999;
            for(int v=0;v<n;v++){
                if(visited[u]==1 && visited[v]==0){
                    if(d[v]<d[u]+graph[u][v])
                        d[v] = d[v];
                    else{
                        d[v] = d[u] + graph[u][v];
                        parent[v] = u;
                    }
                }
            }
            for(int v=0;v<n;v++){
                if(d[v]<=min && d[v]!=0 && visited[v]==0){
                    min = d[v];
                    u=v;
                }
            }
            visited[u] = 1;
        }
        for(i=0;i<n;i++){
            System.out.println("Distance from " + source + " --> " + i + " is " + d[i]);
        }
        for(i=0;i<n;i++){
            System.out.println("Parent of node " + i + " is " + parent[i]);
        }
    }
}
