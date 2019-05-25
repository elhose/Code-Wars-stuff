import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {


        System.out.println(expandedForm(12));

    }


    public static String expandedForm(int num){

        StringBuilder stbud = new StringBuilder();
        List<Integer> lista = new ArrayList<>();

        while(num >0 ){
            lista.add(num%10);
            num = num/10;
        }

        int temp;

        for (int i=lista.size()-1; i>=0; i--){
            if (lista.get(i) != 0){
                temp = lista.get(i) * (int) Math.pow(10,i);
                stbud.append(temp + " + ");
            }
        }

        return stbud.delete(stbud.length()-3,stbud.length()).toString();
    }
}


