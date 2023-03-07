package assiangroup.programms;

public class FactorialUsingRecursion {

    public static int fact(int Num){
        if(Num==1){
            return 1;
        }else{
            return Num*fact(Num-1);
        }
    }

    public static void main(String[] args){
        System.out.println(fact(5));
    }
}
