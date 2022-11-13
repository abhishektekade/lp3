import java.util.Scanner;

class Knapsack01 {

    public int knapSack(int W, int wt[], int val[], int n)
    {

        if (n == 0 || W == 0){
            return 0;
        }

        if (wt[n - 1] > W){
            return knapSack(W, wt, val, n - 1);

        }

        else {
            return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of items");
        int n=sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];

        System.out.println("Enter the weights of each items");
        for(int i=0;i<n;i++)
           wt[i] = sc.nextInt();

        System.out.println("Enter the values of each items");
        for(int i=0;i<n;i++)
            val[i] = sc.nextInt();

        System.out.println("Enter maximum volume of knapsack :");
        int W=sc.nextInt();
        Knapsack01 k01 = new Knapsack01();
        long startTime = System .nanoTime();
        int totalProfit = k01.knapSack(W, wt, val, n);
        long endTime = System.nanoTime();
        long timeTaken = endTime-startTime;
        System.out.println("Profit : " + totalProfit);
        System.out.println("Time taken : "+timeTaken);
    }
}