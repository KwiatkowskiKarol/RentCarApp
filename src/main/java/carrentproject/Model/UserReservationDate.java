package carrentproject.Model;

import java.time.LocalDateTime;

public class UserReservationDate {
    private LocalDateTime executionTime;
    private LocalDateTime updateTime;
    private LocalDateTime lastReadTime;

    public UserReservationDate(){}

    public UserReservationDate(LocalDateTime executionTme, LocalDateTime updateTime, LocalDateTime lastReadTime){
        this.executionTime = executionTme;
        this.updateTime = updateTime;
        this.lastReadTime = lastReadTime;
    }
    public UserReservationDate create(UserReservationList reservation){
        return new UserReservationDate(reservation.getExecutionTime(), reservation.getUpdateTime(),reservation.getLastReadTime());
    }

    public LocalDateTime getExecutionTime(){
        return executionTime;
    }
    public LocalDateTime getUpdateTime(){
        return updateTime;
    }
    public LocalDateTime getLastReadTime(){
        return lastReadTime;
    }
}
