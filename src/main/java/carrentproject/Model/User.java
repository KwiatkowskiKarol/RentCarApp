package carrentproject.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User{
    private String firstName, lastName, phoneNumber;
    private UserReservation UserReservation;
    private Long id;
    private User(){}

    public User(Long id, String firstName, String lastName, String phoneNumber){
        this.id = id;
        this.firstName = firstName = "";
        this.lastName = lastName = "";
        this.phoneNumber = phoneNumber = "";
        this.UserReservation = new UserReservation();
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
    public UserReservation getUserReservation() {
        return UserReservation;
    }

    public void setUserReservation(UserReservation userReservation) {
        this.UserReservation = userReservation;
    }
}