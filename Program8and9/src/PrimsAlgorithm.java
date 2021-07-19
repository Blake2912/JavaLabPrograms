import java.util.Scanner;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i,j,n;
        System.out.println("Enter the number of edges:");
        n = input.nextInt();
        int [][] graph = new int [n][n];
        int [] visited = new int [n];
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                graph[i][j] = input.nextInt();
            }
        }

    }
}
