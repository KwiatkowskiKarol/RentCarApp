package carrentproject.Repo;

import carrentproject.Model.CarReservation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoRepo {
    private static DoRepo ourInstance = new DoRepo();

    public static DoRepo getInstance() {
        return ourInstance;
    }

    private DoRepo() {
    }

    private List<CarReservation> carReservations = new ArrayList<>();

    public List<CarReservation> collectionAccess() {
        return carReservations;
    }

    public void setCarReservations(List<CarReservation> carReservations) {
        this.carReservations = carReservations;
    }

    public Optional<CarReservation> getReservationById(long id) {

        return carReservations.stream().filter(x -> x.getReservationId().equals(id)).findFirst();

    }

    public boolean isInRepoById(final long id) {
        return carReservations.stream().anyMatch(u -> u.getReservationId().equals(id));
    }
}