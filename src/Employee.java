public class Employee extends Person{
    private int employeeNbr;
    private String position;

    public Employee(String ssn, String name, String address, String telephonNumber, String userName, String password, int employeeNbr, String position) {
        super(ssn, name, address, telephonNumber, userName, password);
        this.employeeNbr = employeeNbr;
        this.position = position;
    }

    protected int getEmployeeNbr() {
        return employeeNbr;
    }

    protected void setEmployeeNbr(int employeeNbr) {
        this.employeeNbr = employeeNbr;
    }

    protected String getPosition() {
        return position;
    }

    protected void setPosition(String position) {
        this.position = position;
    }


}
