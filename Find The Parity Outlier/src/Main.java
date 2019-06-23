public class Main {

    public static void main(String[] args) {

        int[] numbers = {160, 3, 1719, 19, 11, 13, -21};

        System.out.println(find(numbers));
    }

    public static int find(int[] integers){
        int numberOfOdd = 0;
        int numberOfEven = 0;
        for (int i=0;i<3;i++){
            if (integers[i]%2==0){
                numberOfEven++;
            }else {
                numberOfOdd++;
            }
        }

        if (numberOfEven > numberOfOdd){
            for (int i=0;i<integers.length;i++){
                if (integers[i]%2!=0){
                    return integers[i];
                }
            }
        }else {
            for (int i=0;i<integers.length;i++){
                if (integers[i]%2==0){
                    return integers[i];
                }
            }
        }
        return -1;
    }
}
