package carrentproject.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.NoSuchElementException;

import carrentproject.Model.User;
import carrentproject.Model.UserReservation;
import carrentproject.Model.UserReservationDate;
import carrentproject.Model.UserReservationList;
import carrentproject.Repo.DoRepo;

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
                return (UserReservationList) optionalUserReservation.get();
            }
        }
        throw new NoSuchElementException("Element with this id not exist");
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

    public UserReservation updateUser(Long id, UserReservation userReservation){
        if (DoRepo.getInstance().isInRepoById(id)){
            UserReservation userToUpdate = getReservationById(id);

            userToUpdate.setReservationCarUser.getReservedCars();
            userToUpdate.setRecordTimes(UserReservationList.isRecordTimes());

            if (UserReservationList.isRecordTimes()) {
                userToUpdate.setUpdateTime(LocalDateTime.now());
                userToUpdate.setLastReadTime(UserReservationList.getLastReadTime());
            }

            DoRepo.getInstance().collectionAccess().remove(getReservationById(id));
            DoRepo.getInstance().collectionAccess().add(userToUpdate);
            return userToUpdate;
        }
        throw new NoSuchElementException("Element doesn't exist");
    }

    public UserReservationDate getTimeById(long id){
        return new UserReservationDate().create((UserReservationList) getReservationById(id));
    }
}