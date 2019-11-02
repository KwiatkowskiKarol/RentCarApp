package carrentproject.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserReservationList extends UserReservation {
    private Long id;
    private List<UserReservation> userReservations;
    private LocalDateTime executionTime;
    private LocalDateTime updateTime;
    private static LocalDateTime lastReadTime;
    private User user;
    private static boolean recordTimes;
    public UserReservationList(){}


    public UserReservationList(Long id, ArrayList<String> reservedCars) {
        this.id = id;
        this.userReservations = userReservations;
        this.executionTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.lastReadTime = LocalDateTime.now();
        this.recordTimes = true;

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public List<UserReservation> getUserReservations(){
        return userReservations;
    }
    public void setUserReservations(List<UserReservation> userReservations){
        this.userReservations = userReservations;
    }

    public LocalDateTime getExecutionTime() { return executionTime; }

    public void setExecutionTime(LocalDateTime executionTime) { this.executionTime = executionTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }

    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    public static LocalDateTime getLastReadTime() { return lastReadTime; }

    public void setLastReadTime(LocalDateTime lastReadTime) { this.lastReadTime = lastReadTime; }

    public static boolean isRecordTimes() { return recordTimes; }

    public void setRecordTimes(boolean recordTimes) { this.recordTimes = recordTimes; }
}


