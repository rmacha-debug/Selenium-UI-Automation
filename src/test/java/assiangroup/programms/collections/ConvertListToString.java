package assiangroup.programms.collections;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertListToString {

    public static void main(String[] args){
        ArrayList<String> listDays = new ArrayList<String>();
        listDays.add("Sunday");
        listDays.add("Monday");
        listDays.add("Tuesday");
        listDays.add("Wednesday");
        listDays.add("Thursday");
        System.out.println("list Days "+listDays);

        //convert list to string
     //   String days = listDays.toString().replace(",","").replaceAll("\\[|\\]","");
      //  System.out.println(days);

        //method 2
        String StrPattern = "[a-zA-Z]+";
        Pattern p = Pattern.compile(StrPattern);
        Matcher m = p.matcher(listDays.toString());
        String days="";
        while (m.find()){
            days=days+" "+m.group();
        }
        System.out.println(days);
        //method3:
        String strListString = StringUtils.join(listDays, ",");
        System.out.println(strListString);

        //java 8
        String ListString = String.join(", ", listDays);
        System.out.println(ListString);

        //String Builder

        StringBuilder stringBuilder = new StringBuilder();
        for(String strDay : listDays){
            stringBuilder.append(strDay);
            stringBuilder.append(",");
        }
        System.out.println(stringBuilder.toString());

    }


}
