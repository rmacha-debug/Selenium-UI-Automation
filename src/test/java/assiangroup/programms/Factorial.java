package assiangroup.programms;

public class Factorial {
    public static int getFactorial(int Number){
        int result = 1;
        for(int i=1;i<=Number;i++){
            result = result*i;
        }
        return  result;
    }

    public static void main(String[] args){
        System.out.println(Factorial.getFactorial(5));
    }
}
