package carrentproject.Service;

import carrentproject.Model.CarReservation;

import java.util.ArrayList;

public class Factory {

    public static CarReservation create(long id, ArrayList<String> reservationName) {
        return new CarReservation(id, reservationName);

    }
}