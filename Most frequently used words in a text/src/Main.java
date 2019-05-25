import java.util.*;

public class Main {

    public static void main(String[] args) {

        String asd = "In a village of La Mancha, the name of which I have no desire to call to\n" +
                "mind, there lived not long since one of those gentlemen that keep a lance\n" +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for\n" +
                "coursing. An olla of rather more beef than mutton, a salad on most\n" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra\n" +
                "on Sundays, made away with three-quarters of his income.";

        System.out.println(top3(asd));

    }

    public static List<String> top3(String s) {

        String[] stringArray = s.trim().split(" ");
        List<String> returnedList = new ArrayList<>();
        Map<String, Integer> mapOfStrings = new HashMap<>();
        for (int i=0; i<stringArray.length; i++){
            stringArray[i] = stringArray[i].replaceAll("[^\\w\b(?!')\b]","").toLowerCase();
            if (!mapOfStrings.containsKey(stringArray[i])){
                mapOfStrings.put(stringArray[i],1);
            }else{
                mapOfStrings.replace(stringArray[i],mapOfStrings.get(stringArray[i]),mapOfStrings.get(stringArray[i])+1);
            }
        }

        int numberOfRepeats;
        int maxCount = -1;
        String tempKey = null;

        if (mapOfStrings.keySet().size() < 3){
            numberOfRepeats = mapOfStrings.keySet().size();
        }else{
            numberOfRepeats = 3;
        }

        for (int i=0 ;i<numberOfRepeats; i++){
            for (String key: mapOfStrings.keySet()){
                if (mapOfStrings.get(key) > maxCount && !returnedList.contains(key)){
                    maxCount = mapOfStrings.get(key);
                    tempKey = key;
                }
            }
            //jakby ktospacje najebał jak pojebany to to usuwa
//            if (tempKey.equals("")){
//                numberOfRepeats++;
//            }
            returnedList.add(tempKey);
            maxCount =-1;
        }

//            returnedList.remove("");
        return returnedList;
    }
}
