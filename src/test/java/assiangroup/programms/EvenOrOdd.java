package assiangroup.programms;

public class EvenOrOdd {

    public static String getEvenOrAdd(int num){
        String value;
        if(num%2==0){
            value= "even Number";
        }else{
            value= "odd Number";
        }
        return  value;
    }

    public static void main(String[] args){
        System.out.println(getEvenOrAdd(100));
        System.out.println(getEvenOrAdd(3));
    }
}
