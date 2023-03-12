package assiangroup.programms.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratethroughList {

    public static void main(String[] args) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("Jason", "IT", 10));
        employeeArrayList.add(new Employee("jack", "marketing", 11));
        employeeArrayList.add(new Employee("mack", "sales", 12));
        employeeArrayList.add(new Employee("tom", "telemarketing", 13));

//get Iterator using iterator method of the List
        Iterator<Employee> itrEmployees = employeeArrayList.iterator();

        while( itrEmployees.hasNext() )
            System.out.println(itrEmployees.next() );

        for(Employee emp : employeeArrayList){
            System.out.println( emp );
        }
        System.out.println("for each loop");
        employeeArrayList.forEach( Employee -> System.out.println(Employee) );
    }
}