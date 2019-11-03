package carrentproject.Service;

import carrentproject.Model.UserReservation;
import carrentproject.Model.UserReservationDate;
import carrentproject.Repo.DoRepo;

import java.time.LocalDateTime;
import java.util.*;

public class Crud {

    public Crud() {
//Make crud Service
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
                UserReservation userReservation = optionalUserReservation.get();
                if (userReservation.isRecordTimes()){
                    userReservation.setLastReadTime(LocalDateTime.now());
                }
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

    public UserReservation updateUser(Long id, UserReservation user){
        if (DoRepo.getInstance().isInRepoById(id)){
            UserReservation userToUpdate = getReservationById(id);

            userToUpdate.setReservedCars(user.getReservedCars());
            userToUpdate.setRecordTimes(user.isRecordTimes());

            if (user.isRecordTimes()) {
                userToUpdate.setUpdateTime(LocalDateTime.now());
                userToUpdate.setLastReadTime(user.getLastReadTime());
            }


            DoRepo.getInstance().collectionAccess().remove(getReservationById(id));
            DoRepo.getInstance().collectionAccess().add(userToUpdate);


            return userToUpdate;
        }

        throw new NoSuchElementException("Element doesn't exist");
    }

    public UserReservationDate getTimeById(long id) {
        return new UserReservationDate().create((getReservationById(id)));
    }

}
