package assiangroup.programms.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConvertMapToList {

    public static void main(String[] args){
        HashMap<String, Employee> employeeMap = new HashMap<String,Employee>();

        employeeMap.put("emp01", new Employee("Jason", "IT", 10));
        employeeMap.put("emp02", new Employee("Aaron", "Supply Chain", 11));
        employeeMap.put("emp04", new Employee("Oliver", "Marketing", 12));
        employeeMap.put("emp03", new Employee("Raj", "IT", 13));
        System.out.println(employeeMap.toString());
        ArrayList<String> aListEmployeeIds = new ArrayList<String>(employeeMap.keySet());

        System.out.println("ArrayList containing HashMap Keys: ");
        for(String strEmpId : aListEmployeeIds)
            System.out.println(strEmpId);

        ArrayList<Employee> aListEmployeeValues = new ArrayList<Employee>(employeeMap.values());
        System.out.println("ArrayList containing HashMap Values: ");
        for(Employee empObj : aListEmployeeValues)
            System.out.println(empObj.toString());

        ArrayList<Map.Entry<String, Employee>> aListEntries =
                new ArrayList<Map.Entry<String, Employee>>(employeeMap.entrySet());

        System.out.println("ArrayList containing HashMap Entries: ");
        for(Map.Entry<String, Employee> empEntry : aListEntries)
            System.out.println(empEntry);

        System.out.println("get 1st record from ArrayList");
        System.out.println(aListEntries.get(1));
        }
    }
