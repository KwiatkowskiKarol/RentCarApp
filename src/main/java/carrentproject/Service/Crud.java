package carrentproject.Service;

import java.util.*;

import carrentproject.Model.User;
import carrentproject.Model.UserReservation;
import carrentproject.Repo.DoRepo;
import java.util.NoSuchElementException;

public class Crud {

    public Crud() {
    }

    public boolean createUserReservation(UserReservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Object is null");

        DoRepo.getInstance().collectionAccess().add(reservation);
        return true;
    }

    public UserReservation getReservationById(Long id) {
        if (DoRepo.getInstance().isInRepoById(id)) {
            Optional<UserReservation> optionalUserReservation = DoRepo.getInstance().getReservationById(id);
            if (optionalUserReservation.isPresent()) {
                return optionalUserReservation.get();
            }
        }
        throw new NoSuchElementException("Element doesn't exist");
    }

    public boolean deleteUserReservation (Long id) {
        if (DoRepo.getInstance().isInRepoById(id)) {
            DoRepo.getInstance().collectionAccess().remove(getReservationById(id));
            return true;
        }
        return false;
    }

    public List<UserReservation> getAllUserReservation() {
        return new ArrayList<UserReservation>(DoRepo.getInstance().collectionAccess());
    }

    public UserReservation updateCUser(Long id, User user){
        if (DoRepo.getInstance().isInRepoById(id)){
            UserReservation userToUpdate = getReservationById(id);

            user.setUserReservation(user.getUserReservation());


            DoRepo.getInstance().collectionAccess().remove(getReservationById(id));
            DoRepo.getInstance().collectionAccess().add(userToUpdate);


            return userToUpdate;
        }

        throw new NoSuchElementException("Element doesn't exist");
    }

}