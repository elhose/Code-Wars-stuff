public class Main {

    public static void main(String[] args) {

        System.out.println(check("The quick brown fox jumps over the lazy dog.!!!!!!"));

    }



    public static boolean check(String sentence){
        char[] array = new char[26];
        for (char i='a'; i<='z'; i++){
            array[i-97] = i;
        }

        sentence = sentence.replaceAll("\\W","");
        sentence = sentence.toLowerCase();
        char[] sentenceArray = sentence.toCharArray();

        for (int i=0; i<array.length; i++){
            for (int j=0; j<sentenceArray.length; j++){
                if (array[i] == sentenceArray[j]){
                    array[i] = '0';
                }
            }
        }

        for (int i=0; i<array.length; i++){
            if (array[i] != '0'){
                return false;
            }
        }

        return true;
    }
}
