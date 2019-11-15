package carrentproject.Model;

import java.util.ArrayList;

public class DeleteCarReservation {

    private long reservationId;
    private ArrayList<String> deletedCars;

    public DeleteCarReservation() {

    }

    public DeleteCarReservation(long id, ArrayList<String> deletedCars){
        this.reservationId = id;
        this.deletedCars = deletedCars;
    }

    public DeleteCarReservation(ArrayList<String> deletedCars) {
    }

    public ArrayList<String> getDeletedCars() {
        return deletedCars;
    }

    public void setDeletedCars(ArrayList<String> reservedCars) {
        this.deletedCars = deletedCars;
    }

}
