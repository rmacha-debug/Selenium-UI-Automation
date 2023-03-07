package assiangroup.programms;

import java.time.Year;

public class LeapYear {

    public static  String getLeapYear(int year){
        String LeapYear;
        if((year % 4 ==0 && year % 100 !=0)|| year % 400==0){
            LeapYear = year+ " Year is Leap year";
        }else{
            LeapYear =year+ " Year is not Leap year";
        }
        return  LeapYear;
    }

    public static void main(String[] args){
        System.out.println(LeapYear.getLeapYear(1996));
        System.out.println(LeapYear.getLeapYear(2000));
        System.out.println(LeapYear.getLeapYear(2100));
    }
}
