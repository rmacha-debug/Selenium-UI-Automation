package assiangroup.programms.dates;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularexpression {

    public static void main(String[] args){
        String test = "I was born on 12-06-1989,I was born on 12-06-1989";
        String StrPattern = "\\d{4}";
        Pattern pattern = Pattern.compile(StrPattern);
        Matcher matcher = pattern.matcher(test);
        String str = " ";
        HashSet<String> set = new HashSet<>();
        while( matcher.find() ) {
            set.add(matcher.group());
        }
        System.out.println(set.size());
    }
}
