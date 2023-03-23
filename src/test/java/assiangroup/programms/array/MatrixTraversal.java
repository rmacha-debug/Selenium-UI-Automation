package assiangroup.programms.array;

import java.util.Arrays;

public class MatrixTraversal {

    public static void printMatrix(String matrix[][]){

        for (String[] row : matrix) {
            // convert each row to a String before printing
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        String [][] matrix = {  { "Hi, I am Karen" },
                { "I'm new to Java"},
                { "I love swimming" },
                { "sometimes I play keyboard"} };
        printMatrix(matrix);
    }
}

