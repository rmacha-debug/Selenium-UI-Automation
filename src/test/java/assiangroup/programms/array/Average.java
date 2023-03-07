package assiangroup.programms.array;

public class Average {

    public static void main(String[] args){
        int array[] = {10,20,30,40,50};
        int n = array.length;
        int sum =0;
        for(int v : array)
            sum += v;
        float average = sum/n;
        System.out.println(average);
    }


}
