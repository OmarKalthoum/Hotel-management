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

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nSocial security number: " + ssn + "\nAddress: " + address + "\nPhone Number: " + telephonNumber + "\n\n";
    }
}
