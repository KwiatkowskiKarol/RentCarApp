package carrentproject.Model;

import java.time.LocalDateTime;

public class CarReservationDate {
    private LocalDateTime executionTime;
    private LocalDateTime updateTime;
    private LocalDateTime lastReadingTime;

    public CarReservationDate() {

    }

    public CarReservationDate(LocalDateTime executionTime, LocalDateTime updateTime, LocalDateTime lastReadTime) {
        this.executionTime = executionTime;
        this.updateTime = updateTime;
        this.lastReadingTime = lastReadingTime;
    }
    public CarReservationDate create(CarReservation reservation) {
        return new CarReservationDate(reservation.getExecutionTime(),reservation.getUpdateTime(),reservation.getLastReadTime());
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public LocalDateTime getLastReadingTime() {
        return lastReadingTime;
    }
}