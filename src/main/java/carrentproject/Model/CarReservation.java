package carrentproject.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CarReservation {
    private long reservationId;
    private ArrayList<String> reservedCars;
    private LocalDateTime executionTime;
    private LocalDateTime updateTime;
    private LocalDateTime lastReadTime;
    private User user;
    private boolean recordTimes;

    public CarReservation(){

    }

    public CarReservation(long id, ArrayList<String> reservedCars) {
        this.reservationId = id;
        this.reservedCars = reservedCars;
        this.executionTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.recordTimes = true;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public ArrayList<String> getReservedCars() {
        return reservedCars;
    }

    public void setReservedCars(ArrayList<String> reservedCars) {
        this.reservedCars = reservedCars;
    }

    public LocalDateTime getExecutionTime() { return executionTime; }

    public void setExecutionTime(LocalDateTime executionTime) { this.executionTime = executionTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }

    public void setUpdateTime(LocalDateTime UpdateTime) { this.updateTime = UpdateTime; }

    public LocalDateTime getLastReadTime() { return lastReadTime; }

    public void setLastReadTime(LocalDateTime lastReadTime) { this.lastReadTime = lastReadTime; }

    public boolean isRecordTimes() { return recordTimes; }

    public void setRecordTimes(boolean recordTimes) { this.recordTimes = recordTimes; }

    public void setDeletedCars(ArrayList<String> deletedCars) {
    }
}
