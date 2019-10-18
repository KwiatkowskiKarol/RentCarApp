package carrentproject.Repo;

import carrentproject.Model.UserReservation;
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

    private List<UserReservation> UserReservations = new ArrayList<>();

    public List<UserReservation> collectionAccess() {
        return UserReservations;
    }

    public void setUserReservations(List<UserReservation> userReservations) {
        this.UserReservations = userReservations;
    }

    public Optional<UserReservation> getReservationById(long id) {

        return UserReservations.stream().filter(x -> x.getReservationId().equals(id)).findFirst();

    }

    public boolean isInRepoById(final long id) {
        return UserReservations.stream().anyMatch(u -> u.getReservationId().equals(id));
    }
}