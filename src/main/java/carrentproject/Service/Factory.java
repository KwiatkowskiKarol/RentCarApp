package carrentproject.Service;

import carrentproject.Model.UserReservation;

import java.util.ArrayList;

public class Factory {
    public static UserReservation create(long id, ArrayList<String> reservationName){
        return new UserReservation(id, reservationName);
    }
}
