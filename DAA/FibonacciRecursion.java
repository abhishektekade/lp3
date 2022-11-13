import java.util.Scanner;

public class FibonacciRecursion {
    private static final long KILOBYTE = 1024L;
    private static  final long MICROSECOND = 1000;
    public static long bytesToKilobytes(long bytes) {
        return bytes / KILOBYTE;
    }
    public static long nanosToMicro(long nanos) {
        return nanos / MICROSECOND;
    }

    public int calculate(int n){
        if(n<=1){
            return n;
        }
        return calculate(n-1)+ calculate(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit : ");
        int n = sc.nextInt();
        FibonacciRecursion fi = new FibonacciRecursion();
        long startTime = System.nanoTime();
        System.out.println(fi.calculate(n-1));
        long endTime = System.nanoTime();
        long time = endTime-startTime;
        System.out.println("\nTime taken for execution of Recursion in Microseconds : " + nanosToMicro(time));
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("\nUsed memory in kilobytes: "
                + memory);
    }
}
