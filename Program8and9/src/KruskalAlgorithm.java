import java.util.Scanner;

public class KruskalAlgorithm {


    static void find(int u, int v, int[] parent){
        if(parent[u] != parent[v]){
            union(u,v,parent);
        }
    }
    static void union(int u,int v, int [] parent){
        int prev = parent[v];
        parent[v] = parent[u];
        for(int i=0;i<parent.length;i++){
            if(parent[i]==prev){
                parent[i]=parent[u];
            }
        }
        System.out.println("Edge selected is: " + u +" -> " + v);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,i,j,ne=0;
        int u=0,v=0;
        System.out.println("Enter the number of vertices:");
        n = input.nextInt();
        int [][] graph = new int [n][n];
        int [][] adj = new int [n][n];
        System.out.println("Enter the graph");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                graph[i][j] = input.nextInt();
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                adj[i][j] = graph[i][j];
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(adj[i][j] != 999 && adj[i][j] != 0){
                    ne++;
                }
                adj[i][j] = adj[j][i] = 999;
            }
        }

        int [] parent = new int[n];
        for(i=0;i<n;i++){
            parent[i] = i;
        }
        for(int count=0;count<ne;count++){
            int min = 999;
            for(i=0;i<n;i++){
                for( j=0;j<n;j++){
                    if(graph[i][j]<min&&graph[i][j]!=0){
                        min = graph[i][j];
                        u=i;
                        v=j;
                    }
                }
            }
            find(u,v,parent);
            graph[u][v] = graph[v][u] = 999;
        }

    }
}

/*
0 8 999 1
8 0 3 2
999 3 0 9
1 2 9 0

https://meet.google.com/shb-iwvu-ahk
 */