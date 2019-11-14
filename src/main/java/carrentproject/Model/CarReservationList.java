package carrentproject.Model;

import java.util.List;

public class CarReservationList {
    private Long id;
    private List<CarReservation> carReservations;

    public CarReservationList() {

    }
    public CarReservationList(Long id, List<CarReservation> carReservations) {
        this.id = id;
        this.carReservations = carReservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CarReservation> getCarReservations() {
        return carReservations;
    }

    public void setCarReservation(List<CarReservation> carReservations) {
        this.carReservations = carReservations;
    }
}