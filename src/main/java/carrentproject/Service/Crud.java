package carrentproject.Service;

import carrentproject.Model.CarReservation;
import carrentproject.Model.CarReservationDate;
import carrentproject.Repo.DoRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class Crud {

    public Crud() {
    }

    public boolean createCarReservation(CarReservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Object is null");
        DoRepo.getInstance().collectionAccess().add(reservation);
        return true;
    }

    public CarReservation getReservationById(Long id) {
        if (DoRepo.getInstance().isInRepoById(id)) {
            Optional<CarReservation> optionalCarReservation = DoRepo.getInstance().getReservationById(id);
            if (optionalCarReservation.isPresent()) {
                CarReservation carReservation = optionalCarReservation.get();
                if (carReservation.isRecordTimes()){
                    carReservation.setLastReadTime(LocalDateTime.now());
                }
                return optionalCarReservation.get();
            }
        }
        throw new NoSuchElementException("Element doesn't exist");
    }

    public boolean deleteCarReservation (Long id) {
        if (DoRepo.getInstance().isInRepoById(id)) {
            DoRepo.getInstance().collectionAccess().remove(getReservationById(id));
            return true;
        }
        return false;
    }
    public void deleteCarReservation() {
    }

    public List<CarReservation> getAllCarReservation() {
        return new ArrayList<>(DoRepo.getInstance().collectionAccess());
    }

    public CarReservation updateCar(Long id, CarReservation car){
        if (DoRepo.getInstance().isInRepoById(id)){
            CarReservation carToUpdate = getReservationById(id);
            carToUpdate.setReservedCars(car.getReservedCars());
            carToUpdate.setRecordTimes(car.isRecordTimes());

            if (car.isRecordTimes()) {
                carToUpdate.setUpdateTime(LocalDateTime.now());
                carToUpdate.setLastReadTime(car.getLastReadTime());
            }

            DoRepo.getInstance().collectionAccess().remove(getReservationById(id));
            DoRepo.getInstance().collectionAccess().add(carToUpdate);
            return carToUpdate;
        }
        throw new NoSuchElementException("Element doesn't exist");
    }

    public List<CarReservation> getAllUsers() {
        return new ArrayList<>(DoRepo.getInstance().collectionAccess());
    }

    public CarReservationDate getTimeById(long id) {
        return new CarReservationDate().create((getReservationById(id)));
    }
}
