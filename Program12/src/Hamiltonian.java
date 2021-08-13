import java.util.*;
public class Hamiltonian {
    static int n;
    static int[][] adj;
    static int[] path;
    public static boolean contains(int[] arr, int item) {
        for (int n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }
    public static void findCycle(int startVertex, int pos) {
        for(int i=0;i<n;i++) {
            if(adj[startVertex][i]!=0) {
                generatePath(startVertex,i,pos);
                for(int j=pos+1;j<n;j++)
                    path[j]=999;
            }
        }
    }
    public static void generatePath(int startVertex, int nextVertex, int pos) {
        path[pos]=startVertex;
        pos=pos+1;
        if(!contains(path,nextVertex) && pos<n) {
            path[pos]=nextVertex;
            startVertex=nextVertex;
            findCycle(startVertex,pos);
            if(pos==n-1 && adj[nextVertex][path[0]]==1) {
                for(int i=0;i<n;i++) {System.out.print(path[i]+"-->");}
                System.out.println(path[0]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n=s.nextInt();
        adj= new int[n][n];
        path = new int[n];
        System.out.println("Enter the adjacency matrix");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                adj[i][j]=s.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {path[j]=999;}
            System.out.println("Cycle starting from vertex " + i);
            findCycle(i,0);
        }
    }
}
