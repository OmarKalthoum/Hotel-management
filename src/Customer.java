public class Customer {

    private String ssn;
    private String name;
    private String address;
    private String telephonNumber;
    private String password;

    public Customer(String ssn, String name, String address, String telephonNumber, String password) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.telephonNumber = telephonNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
