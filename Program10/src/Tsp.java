import java.util.*;
public class Tsp{
    public static void main(String[] args) {
        int[][] c =new int[10][10];
        int[] tour =new int[10];
        Scanner sc = new Scanner(System.in);
        int i,j,cost;
        System.out.println("TSP Dynamic Programming");
        System.out.println("Enter the number of cities");
        int n=sc.nextInt();
        if(n<=1)
        {
            System.out.println("Path is not Possible");
            System.exit(0);
        }
        System.out.println("Enter cost matrix");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                c[i][j]=sc.nextInt() ;
        for(i=1;i<=n;i++)
            tour[i]=i;
        cost = tsp_sp(c,tour,1,n);
        System.out.println("The accurate path is ");
        for(i=1;i<=n;i++)
            System.out.print(tour[i]+"-->");
        System.out.println("1");
        System.out.println("The accurate min cost is "+cost);
        System.out.println("***************************************************");
    }
    static int tsp_sp(int[][] c, int[] tour, int start, int n)
    {
        int[] min_tour =new int[10];
        int[] temp =new

                        int[10];
        int min_cost=999;
        int cost;
        int i;
        int j;
        int k;
        if(start == n-1)
        {
            return (c[tour[n-1]][tour[n]] + c[tour[n]][1]);
        }
        for(i=start+1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
                temp[j]=tour[j];
            temp[start+1] = tour[i];
            temp[i]=tour[start+1];
            if((c[tour[start]][tour[i]] +
                    (cost= tsp_sp(c,temp,start+1,n)))<min_cost)

            {
                min_cost=c[tour[start]][tour[i]]+cost;
                for(k=1;k<=n;k++)
                    min_tour[k]=temp[k];

            }
        }
        for(i=1;i<=n;i++)
            tour[i]=min_tour[i];
        return min_cost;
    }

}
