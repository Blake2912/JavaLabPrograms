import java.util.Scanner;

// Implement in Java, the 0/1 Knapsack problem using Dynamic Programming method
public class KnapsackUsingDynamicProgramming {

    public static void Knapsack_Using_Dynamic_Programming(int [] profit, int [] weight, int knapsack_weight){
        int profit_value,i,j,maxVal;
        int n = profit.length; // This will give the number of items present in the lot.
        int [][] knapsack_array_2D = new int[n+1][knapsack_weight+1]; // Syntax = array[rowVal][colVal]
        for(i=0;i<n+1;i++){
            for(j=0;j<knapsack_weight+1;j++){
                if(i==0 || j == 0){
                    knapsack_array_2D[i][j] = 0;
                }
                else{
                    if(j<weight[i-1]){
                        knapsack_array_2D[i][j] = knapsack_array_2D[i-1][j];
                    }
                    else{
                        // Here we need to find the maximum value of the previous value and the resulting value
                        maxVal = max(knapsack_array_2D[i-1][j],knapsack_array_2D[i-1][j-weight[i-1]]+profit[i-1]);
                        knapsack_array_2D[i][j] = maxVal;
                    }
                }
            }
        }
        System.out.println("The selection array:");
        for(i=0;i<n+1;i++){
            for(j=0;j<knapsack_weight+1;j++){
                System.out.print(knapsack_array_2D[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
        profit_value = knapsack_array_2D[n][knapsack_weight];
        System.out.println("The profit array:");
        for(i=0;i<n;i++){
            System.out.print(profit[i] + " ");
        }
        System.out.println("\nThe weight array:");
        for(i=0;i<n;i++){
            System.out.print(weight[i] + " ");
        }
        System.out.println("\nThe profit is: "+profit_value);
    }

    public static int max(int a, int b){
        int max_val = a;
        if(b > max_val){
            max_val = b;
        }
        return max_val;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,i,knapsack_weight;
        System.out.println("Enter the weight of the bag/Knapsack of the bag");
        knapsack_weight = input.nextInt();
        System.out.println("Enter the number of items you have: ");
        n = input.nextInt();

        int [] profit_array = new int[n];
        int [] weight_array = new int[n];
        for(i=0;i<n;i++){
            System.out.print("Enter the profit for the item "+(i+1) + ": ");
            profit_array[i] = input.nextInt();
            System.out.print("Enter the weight for the item "+(i+1) + ": ");
            weight_array[i] = input.nextInt();
        }
        Knapsack_Using_Dynamic_Programming(profit_array,weight_array,knapsack_weight);
    }
}
