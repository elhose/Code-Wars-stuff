public class Main {

    public static void main(String[] args) {
          System.out.println(longest( "abedadasfas","acdkhukjklsdfsfd"));
    }

    public static String longest (String s1, String s2){
        String longest = s1.concat(s2);
        StringBuilder stbud = new StringBuilder(longest);
        String temp;

               //sorting
        int k = 0;
        boolean stop = false;
        while(!stop){
            for (int i=0; i<stbud.length(); i++){
                if (i+2 <= stbud.length() && stbud.substring(i,i+1).compareTo(stbud.substring(i+1,i+2)) > 0 ){
                    temp = stbud.substring(i,i+1);
                    stbud.replace(i,i+1,stbud.substring(i+1,i+2));
                    stbud.replace(i+1,i+2,temp);
                    k++;
                }
            }

            if (k==0){
                stop = true;
            }else{
                k = 0;
            }
        }
                //deleting unnecessary signs
        for (int i=0; i<stbud.length(); i++){
            if (i+2 <= stbud.length() && stbud.substring(i,i+1).compareTo(stbud.substring(i+1,i+2)) == 0 ){
                stbud.deleteCharAt(i+1);
                i--;
            }
        }
        return stbud.toString();
    }
}


