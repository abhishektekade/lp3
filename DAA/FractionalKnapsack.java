import java.io.IOException;
import java.util.Scanner;

class FractionalKnapsack
{
    public float calculateProfit(int max_qty,int[][] array, int n ){
        int i,j=0;
        int m=max_qty;
        float max,sum = 0;
        while(m>=0)
        {
            max=0;
            for(i=0;i<n;i++)
            {
                if(((float)array[1][i])/((float)array[0][i])>max)
                {
                    max=((float)array[1][i])/((float)array[0][i]);
                    j=i;
                }
            }
            if(array[0][j]>m)
            {
                System.out.println("Quantity of item number: " +  (j+1) + " added is " +m);
                sum+=m*max;
                m=-1;
            }
            else
            {
                System.out.println("Quantity of item number: " + (j+1) + " added is " + array[0][j]);
                m-=array[0][j];
                sum+=(float)array[1][j];
                array[1][j]=0;
            }
        }
        return sum;
    }
    public static void main(String args[]) throws IOException
    {
        int i,j=0,max_qty,n;
        float sum=0;
        Scanner sc = new Scanner(System.in);
        int array[][]=new int[2][20];
        System.out.println("Enter no of items");
        n=sc.nextInt();

        System.out.println("Enter the weights of each items");
        for(i=0;i<n;i++)
            array[0][i]=sc.nextInt();

        System.out.println("Enter the values of each items");
        for(i=0;i<n;i++)
            array[1][i]=sc.nextInt();

        System.out.println("Enter maximum volume of knapsack :");
        max_qty=sc.nextInt();
        long startTime =System.nanoTime();
        FractionalKnapsack fk = new FractionalKnapsack();
        long endTime = System.nanoTime();
        long totalTime = endTime-startTime;
        float ans = fk.calculateProfit(max_qty,array,n);
        System.out.println("The total profit is " + ans);
        System.out.println("Time taken : "+totalTime);
        sc.close();
    }
}