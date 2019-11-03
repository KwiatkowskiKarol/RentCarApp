package carrentproject.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class UserReservationDate  {
    private LocalDateTime executionTime;
    private LocalDateTime updateTime;
    private LocalDateTime lastReadingTime;

    public UserReservationDate() {

    }

    public UserReservationDate(LocalDateTime executionTime, LocalDateTime updateTime, LocalDateTime lastReadTime) {
        this.executionTime = executionTime;
        this.updateTime = updateTime;
        this.lastReadingTime = lastReadingTime;
    }
    public UserReservationDate create(UserReservation reservation) {
        return new UserReservationDate(reservation.getExecutionTime(),reservation.getUpdateTime(),reservation.getLastReadTime());
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