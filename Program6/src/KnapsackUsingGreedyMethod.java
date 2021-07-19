import java.util.Scanner;

//  Implement in Java, the Knapsack problem using Greedy method.
public class KnapsackUsingGreedyMethod {
    static void calculate_profit_per_weight(int [] profit, int [] weight, float [] profitByWeight){
        int no = profit.length;
        // Here I am converting int to float type for proper division
        float [] temp1 = new float[no];
        float [] temp2 = new float[no];
        for(int i =0;i<no;i++){
            temp1[i] = profit[i];
            temp2[i] = weight[i];
            profitByWeight[i] = temp1[i]/temp2[i];
        }
    }
    static void sort_with_profit_per_weight(int [] profit, int [] weight, float [] profitByWeight){
        int no = profit.length;
        int i,j;
        float temp1;
        int temp2,temp3;
        for(i=0;i<no;i++){
            for(j=0;j<no-i-1;j++){
                if(profitByWeight[j] < profitByWeight[j+1]){
                    // Sort all three arrays in descending order...
                    temp2 = profit[j];
                    profit[j] = profit[j+1];
                    profit[j+1] = temp2;

                    temp3 = weight[j];
                    weight[j] = weight[j+1];
                    weight[j+1] = temp3;

                    temp1 = profitByWeight[j];
                    profitByWeight[j] = profitByWeight[j+1];
                    profitByWeight[j+1] = temp1;

                }
            }
        }
    }
    static void knapsack(int [] profit, int [] weight, float [] profitByWeight, int knapsack_weights){
        int no = profit.length;
        int i;
        float profit_val = 0;
        float knapsack_temp = knapsack_weights;
        float [] choice_array = new float[no];
        float [] temp1 = new float[no];
        for(i =0;i<no;i++){
            temp1[i] = weight[i];
        }
        while(knapsack_temp != 0){
            for(i=0;i<no;i++){
                if(knapsack_temp > temp1[i]){
                    choice_array[i] = 1;
                    profit_val += choice_array[i]*profit[i];
                    knapsack_temp -= temp1[i];
                }
                else{
                    choice_array[i] = knapsack_temp/temp1[i];
                    profit_val += choice_array[i]*profit[i];
                    knapsack_temp -= temp1[i] * choice_array[i];
                }
            }
        }
        for(i=0;i<no;i++){ System.out.print(profitByWeight[i] + " ");}
        System.out.println("\nProfit Array:");
        for(i=0;i<no;i++){ System.out.print(profit[i] + " ");}
        System.out.println("\nWeight Array:");
        for(i=0;i<no;i++){System.out.print(weight[i] + " ");}
        System.out.println("\nChoice Array:");
        for(i=0;i<no;i++){System.out.print(choice_array[i] + " ");}
        System.out.println("\nProfit: "+profit_val);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,i,knapsack_weight;
        System.out.println("Enter the number of items that you have: ");
        n = input.nextInt();
        int [] profit = new int[n];
        int [] weights = new int[n];
        float [] profit_per_unit_weight = new float[n];
        System.out.println("Enter the weight of knapsack:");
        knapsack_weight = input.nextInt();
        for(i=0;i<n;i++){
            System.out.print("Enter the Weight of item " + (i+1) + ": ");
            weights[i] = input.nextInt();
            System.out.print("Enter the Profit of item " + (i+1) + ": ");
            profit[i] = input.nextInt();
        }
        calculate_profit_per_weight(profit,weights,profit_per_unit_weight);
        sort_with_profit_per_weight(profit,weights,profit_per_unit_weight);
        knapsack(profit,weights,profit_per_unit_weight,knapsack_weight);
    }
}
