import java.util.Scanner;

public class PrimsAlgorithm {

    public static void PrimsAlgo(int [][]Graph,int []VisitedArray){
        // First mark every element as unvisited in the visited array 0-Unvisited, 1-Visited
        int n = VisitedArray.length;
        int min,minCost = 0;
        int u=0,v=0;
        for(int i=0;i<n;i++){
            VisitedArray[i] = 0;
        }
        VisitedArray[0] = 1;
        int NumberOfEdges = 1;
        // Here I will take the starting vertex as A i.e. graph[0][0]
        while(NumberOfEdges < n){
            min = 999;
            for(int i=0;i<n;i++){
                if(VisitedArray[i] == 1){
                    for(int j=0;j<n;j++){
                        if(Graph[i][j]<min && Graph[i][j] != 0){
                            min = Graph[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }
            if(VisitedArray[u] == 1 && VisitedArray[v] == 0){
                VisitedArray[v] = 1;
                minCost += min;
                NumberOfEdges++;
                System.out.println("Edge selected is " + u + " - " + v +"\n");
            }
            Graph[u][v] = Graph[v][u] = 999;
        }
        System.out.println("The cost of minimum spanning tree is: " + minCost);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i,j,n;
        System.out.println("Enter the number of edges:");
        n = input.nextInt();
        int [][] graph = new int [n][n];
        int [] visited = new int [n];
        // Input taken
        System.out.println("Enter the graph:");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                graph[i][j] = input.nextInt();
                // We need to remove any parallel edges and loops
                if(i==j){
                    graph[i][j] = 0;
                }
            }
        }
        // Displaying the graph before processing
//        for(i=0;i<n;i++){
//            for(j=0;j<n;j++){
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
        PrimsAlgo(graph,visited);
    }
}
