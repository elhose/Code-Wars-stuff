import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String s= "Program title: Primes\n" +
                "Author: Kern\n" +
                "Corporation: Gold\n" +
                "Phone: +1-503-555-0091\n" +
                "Date: Tues April 9, 2005\n" +
                "Version: 2.0\n" +
                "Level: Alpha";

        String prog = "Ladder";
        String version = "1.5";

        System.out.println(change(s,prog,version));

    }

    private static String change(String s, String prog, String version){
        StringBuilder sb = new StringBuilder("Program: ");
        sb.append(prog + " Author: g964 ");

        Pattern numberPattern = Pattern.compile("[+][1][-](\\d{3})[-](\\d{3})[-](\\d{4})");
        Matcher numberMatcher = numberPattern.matcher(s);

        Pattern versionNumber = Pattern.compile("\\s\\d+[.]\\d+\\D{2}");
        Matcher versionMatcher = versionNumber.matcher(s);

        if (numberMatcher.find() && (versionMatcher.find())){
            sb.append("Phone: +1-503-555-0090 ");
            sb.append("Date: 2019-01-01 ");

            String versionInData = s.substring(versionMatcher.start(),versionMatcher.end());
            versionInData = versionInData.trim();
            versionInData = versionInData.substring(0,versionInData.length()-2);


            if (versionInData.equals("2.0")){
                sb.append("Version: 2.0");
            }else {
                sb.append("Version: " + version);
            }

        } else {
            return "ERROR: VERSION or PHONE";
        }

        return sb.toString();
    }
}
