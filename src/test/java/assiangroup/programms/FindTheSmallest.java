package assiangroup.programms;

public class FindTheSmallest {

    public static void  main(String[] args){
        int a =10;
        int b=50;
        int c = 100;
        if(a/b==0 && a/c==0){
            System.out.println("a is smallest");
        }else if(b/a==0 && b/a==0){
            System.out.println("b is smallest");
        }else{
            System.out.println("c is smallest");
        }
    }
}
