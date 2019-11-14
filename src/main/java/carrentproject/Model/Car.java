package carrentproject.Model;

public class Car {
    public String carType;
    private Long id;
    private String carModel;
    private double carPrice;
    private String carReservation;
    private long reservationId;
    private String isReserved;

    public Long id() {
        return id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public String getCar() {
        return getCarType() + getCarModel();
    }

    public String getCarReservation() {
        return carReservation;
    }

    public void setCarReservation(String CarReservation) {
        this.carReservation = CarReservation;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public String isReserved() {
        return isReserved;
    }
}