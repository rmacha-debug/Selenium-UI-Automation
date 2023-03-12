package assiangroup.programms.stringexamples;

public class StringReverse {

    public static void main(String[] args){

        String name = "Rajukumar Macha";
        char[] resultArray = name.toCharArray();
        for(int i=resultArray.length-1;i>=0;i--){
                System.out.print(resultArray[i]);
        }
    }
}
