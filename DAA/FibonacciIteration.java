import java.util.Scanner;

public class FibonacciIteration {
    private static final long KILOBYTE = 1024L;
    private static  final long MILLISECOND = 1000000;
    public static long bytesToKilobytes(long bytes) {
        return bytes / KILOBYTE;
    }
    public static long nanosToMicro(long nanos) {
        return nanos / MILLISECOND;
    }

    public int calculate(int n){
        int f1 = 0;
        int f2 = 1;
        int ans=0;
        for (int i = 2; i < n; i++) {
            ans = f1 + f2;
            f1 = f2;
            f2 = ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit : ");
        int n = sc.nextInt();
        FibonacciIteration fi = new FibonacciIteration();
        long startTime = System.nanoTime();
        System.out.println(fi.calculate(n));
        long endTime = System.nanoTime();
        long time = endTime-startTime;
        System.out.println("\nTime taken for execution in Microseconds : " + nanosToMicro(time));
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("\nUsed memory in kilobytes: "
                + memory);
    }
}
