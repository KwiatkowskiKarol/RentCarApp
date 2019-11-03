package carrentproject.Model;

import java.util.List;

public class UserReservationList extends UserReservation {
    private Long id;
    private List<UserReservation> userReservations;

    public UserReservationList(){}


    public UserReservationList(Long id, List<UserReservation> userReservations) {
        this.id = id;
        this.userReservations = userReservations;
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
}


