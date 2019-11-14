package carrentproject.Service;

import carrentproject.Model.CarReservation;
import carrentproject.Model.CarReservationDate;
import carrentproject.Repo.DoRepo;

import java.time.LocalDateTime;
import java.util.*;

public class Crud {

    public Crud() {
//Make crud Service
    }

    public boolean createUserReservation(CarReservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Object is null");

        DoRepo.getInstance().collectionAccess().add(reservation);
        return true;
    }

    public CarReservation getReservationById(Long id) {
        if (DoRepo.getInstance().isInRepoById(id)) {

            Optional<CarReservation> optionalUserReservation = DoRepo.getInstance().getReservationById(id);
            if (optionalUserReservation.isPresent()) {
                CarReservation carReservation = optionalUserReservation.get();
                if (carReservation.isRecordTimes()){
                    carReservation.setLastReadTime(LocalDateTime.now());
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

    public List<CarReservation> getAllUserReservation() {
        return new ArrayList<CarReservation>(DoRepo.getInstance().collectionAccess());
    }

    public CarReservation updateUser(Long id, CarReservation user){
        if (DoRepo.getInstance().isInRepoById(id)){
            CarReservation userToUpdate = getReservationById(id);

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

    public CarReservationDate getTimeById(long id) {
        return new CarReservationDate().create((getReservationById(id)));
    }

}
