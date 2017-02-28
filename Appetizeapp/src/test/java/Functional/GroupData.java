package Functional;

public class GroupData {
    private final String name;
    private final String email;
    private final String phone;
    private final String message;

    public GroupData(String name, String email, String phone, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }
}
