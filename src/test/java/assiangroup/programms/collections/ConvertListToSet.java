package assiangroup.programms.collections;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertListToSet {

    public static void main(String[] args){
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("White");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Yellow");
        Set<String> setColors = colors.stream().collect(Collectors.toSet());
        System.out.println(setColors);




    }
}
