public class FibonacciSum {
    public static void main(String[]a){
        long i=-3,b=0,c,N=Long.valueOf("100");
        do{
            b+=(c=Math.round(Math.pow(1.618,i+=3)/2.236));
        }while(c<=N);
        System.out.print(b-c);
    }
}
