package assiangroup.programms;

import java.util.ArrayList;

public class Divisors {


    public static ArrayList<Integer> getDivisors(int num){
        ArrayList<Integer> Divisors = new ArrayList<>();
        for(int i=1;i<=num;i++){
            int d= num % i;
            if(d==0){
                Divisors.add(i);
            }
        }
        return  Divisors;
    }
    public static void main(String[] args){
            System.out.println(getDivisors(100));
    }
}
