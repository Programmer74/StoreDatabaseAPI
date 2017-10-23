package usertypes;

public class Pname implements java.io.Serializable{
    private String firstName;
    private String lastName;
    private String middleName;

    public Pname() { }

    public Pname(String fname, String lname, String mname){
        this.firstName = fname;
        this.lastName = lname;
        this.middleName = mname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String toString(){
        return (firstName + " " + lastName);
    }
}
