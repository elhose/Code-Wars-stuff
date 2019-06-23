import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println(listSquared(1,250));
    }

    public static String listSquared(long m, long n){
        List<Long> squaredDivisors = new ArrayList<>();
        List<String> returnedString = new ArrayList<>();

        for (long i=m;i<=n;i++){
            for (long j=1;j<=i;j++){
                if (i%j==0){
                    squaredDivisors.add(j*j);
                }
            }

            long sumOfSquaredDivisors = 0;
            //sum of squared divisors
            for (long divisor:squaredDivisors) {
                sumOfSquaredDivisors += divisor;
            }
            if (Math.sqrt(sumOfSquaredDivisors)%1==0){
                returnedString.add("[" +i+ ", " +sumOfSquaredDivisors+"]");
            }
            squaredDivisors.clear();
        }

        return returnedString.toString();
    }
}
