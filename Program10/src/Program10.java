import java.util.Scanner;

public class Program10 {

    public static final int INFINITY = 999;

    public static void WarshallAlgorithm(int [][]matrix,int n){
        int [][]DistanceMatrix = new int[n+1][n+1];
        // Making a copy of the Main matrix to the distance matrix to perform operations
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                DistanceMatrix[i][j] = matrix[i][j];
            }
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(DistanceMatrix[i][k] + DistanceMatrix[k][j] < DistanceMatrix[i][j]){
                        DistanceMatrix[i][j] = DistanceMatrix[i][k] + DistanceMatrix[k][j];
                    }
                }
            }
        }
        for (int source = 1; source <= n; source++)
            System.out.print("\t" + source);
        System.out.println();
        for (int source = 1; source <= n; source++){
            System.out.print(source + "\t");
            for (int destination = 1; destination <= n; destination++){
                System.out.print(DistanceMatrix[source][destination] + "\t");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n = input.nextInt();
        int [][]WeightedMatrix = new int[n+1][n+1];
        System.out.println("Enter the weighted matrix");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                WeightedMatrix[i][j] = input.nextInt();
                if(i==j){
                    WeightedMatrix[i][j] = 0;
                }
            }
        }

        // Call the functions of the Algorithm
        WarshallAlgorithm(WeightedMatrix,n);
    }
}
