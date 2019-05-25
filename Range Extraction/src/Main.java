public class Main {

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));

        String assistantName = "Aid";
        int birthYear = 2018;

        System.out.println("Hello! my name is " + assistantName);
        System.out.println("I was created in " + birthYear);
    }

    public static String rangeExtraction(int[] arr) {
        String returnedString ="";
        int streak =0;
        int j;

        for (int i=0; i<arr.length; i++){
            j=i;

            while( j+1 < arr.length && arr[j]+1 == arr[j+1]){
             streak++;
             j++;
            }

            if (streak >= 2 && i+streak < arr.length){
                returnedString = returnedString + arr[i] + "-" + arr[i+streak] + ",";
                i +=streak;
            }else {
                returnedString = returnedString + arr[i] + ",";
            }
            streak = 0;
        }
        return returnedString.substring(0,returnedString.length()-1);
    }

}

