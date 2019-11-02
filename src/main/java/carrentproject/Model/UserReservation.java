package carrentproject.Model;
import java.time.LocalDateTime;
import java.util.*;


public class UserReservation {
    public UserReservation setReservationCarUser;
    private long reservationId;
        private boolean isDone = false;
        private ArrayList<String> reservedCars;
        private LocalDateTime executionTime;
        private LocalDateTime updateTime;
        private static LocalDateTime lastReadTime;
        private User user;
        private static boolean recordTimes;

        public UserReservation(){}

        public UserReservation(long id, ArrayList<String> reservedCars) {
            this.reservationId = id;
            this.isDone = false;
            this.reservedCars = reservedCars;
        }

        public Long getReservationId() {
            return reservationId;
        }

        public void setReservationId(long reservationId) {
            this.reservationId = reservationId;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }

        public ArrayList<String> getReservedCars() {
            return reservedCars;
        }

        public void setReservedCars(ArrayList<String> ReservedCars) {
            this.reservedCars = ReservedCars;
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