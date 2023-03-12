package assiangroup.programms.collections;

public class Employee {

    public String empName;
    public String companyName;
    public int empno;

    public Employee(String empName, String companyName, int empno) {
        this.empName = empName;
        this.companyName = companyName;
        this.empno = empno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }





}
