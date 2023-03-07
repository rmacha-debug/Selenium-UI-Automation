package assiangroup.programms;

import java.util.ArrayList;

public class DigitsOfNumber {


    public static ArrayList<Integer> getDigits(int num){
        ArrayList<Integer> digits = new ArrayList<>();
        while(num>0){
            int unitDigit = num %10;
            digits.add(0,unitDigit);
            num=num/10;
        }
        return  digits;
    }
    public static void main(String[] args){
        System.out.println(DigitsOfNumber.getDigits(256));
        System.out.println(DigitsOfNumber.getDigits(789456));
    }
}
