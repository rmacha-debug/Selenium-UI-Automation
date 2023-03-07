package assiangroup.programms;

import java.util.ArrayList;

public class FactorsOfANumber {
    public static ArrayList<Integer> getFactors(int Number) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= Number/2; i++) {
            if (Number % i == 0) {
                al.add(i);
            }
        }
        al.add(Number);
        return al;
    }

    public static void main(String[] args){
        System.out.println(getFactors(100));
    }
}
