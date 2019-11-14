package carrentproject.Model;

public class User {
    private Long id;
    private String name;
    private String surname;
    private CarReservation carReservation;


    public User() { }

    public User (Long id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.carReservation = new CarReservation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public CarReservation getCarReservation() {
        return carReservation;
    }

    public void setCarReservation(CarReservation carReservation) {
        this.carReservation = carReservation;
    }
}