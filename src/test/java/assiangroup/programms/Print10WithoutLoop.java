package assiangroup.programms;

public class Print10WithoutLoop {

    public static void printWihtoutLoop(int n){
        if(n <= 10){
            System.out.println(n);
            printWihtoutLoop( n+1 );
        }
    }

    public static void main(String[] args) {
        printWihtoutLoop(1);
    }
}
