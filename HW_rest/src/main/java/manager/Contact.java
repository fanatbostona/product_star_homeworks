package manager;

public class Contact {

    private String name;
    private String surname;
    private String phone_number;
    private String email_address;


    public Contact(String n, String s, String pn, String ea) {
        this.name = n;
        this.surname = s;
        this.phone_number = pn;
        this.email_address = ea;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    @Override
    public String toString() {
        return "manager.Contact { \n"
                + "Name – " + this.name + "\n"
                + "Surname – " + this.surname + "\n"
                + "Phone number – " + this.phone_number + "\n"
                + "Email – " + this.email_address + " }\n";
    }

    public void editInformation(String n, String s, String pn, String ea) {
        this.name = n;
        this.surname = s;
        this.phone_number = pn;
        this.email_address = ea;
    }
}
