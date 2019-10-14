import java.util.*;
import java.io.*;

public class User {
    private String firstName, lastName, phoneNumber;

    public User(){
        firstName = "";
        lastName = "";
        phoneNumber = "";
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
