import java.io.Serializable;

public class Person implements Serializable {

    private String ssn;
    private String name;
    private String address;
    private String telephonNumber;
    private String userName;
    private String password;

    public Person(String ssn, String name, String address, String telephonNumber, String userName, String password){
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.telephonNumber = telephonNumber;
        this.userName = userName;
        this.password = password;
    }

    public Person(){}

    protected String getSsn() {
        return ssn;
    }

    protected void setSsn(String ssn) {
        this.ssn = ssn;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected String getContactNBR() {
        return telephonNumber;
    }

    protected void setContactNBR(String contactNBR) {
        this.telephonNumber = contactNBR;
    }

    protected String getUserName() {
        return userName;
    }

    protected void setUserName(String userName) {
        this.userName = userName;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

}
