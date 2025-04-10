package ge.ibsu.demo.dto.projections;

public class StaffInfo {
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;

    public StaffInfo(String firstName, String postalCode, String address, String lastName) {
        this.firstName = firstName;
        this.postalCode = postalCode;
        this.address = address;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
