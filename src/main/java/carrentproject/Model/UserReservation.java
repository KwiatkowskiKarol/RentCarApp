package carrentproject.Model;
import java.util.*;


public class UserReservation {
        private long reservationId;
        private boolean isDone = false;
        private ArrayList<String> reservedCars;

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
    }