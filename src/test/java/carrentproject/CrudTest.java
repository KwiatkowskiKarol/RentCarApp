package carrentproject;

import carrentproject.Model.User;
import carrentproject.Model.UserReservation;
import carrentproject.Repo.DoRepo;
import carrentproject.Service.Crud;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import carrentproject.Model.User;
import carrentproject.Model.UserReservation;
import carrentproject.Repo.DoRepo;
import carrentproject.Service.Crud;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CrudTest {

    private DoRepo repository = DoRepo.getInstance();
    private Crud crud = new Crud();

    private ArrayList<String> reservation1 = new ArrayList<String>();
    private ArrayList<String> reservation2 = new ArrayList<String>();
    private ArrayList<String> reservation3 = new ArrayList<String>();
    private ArrayList<String> reservation4 = new ArrayList<String>();
    private ArrayList<String> reservation5 = new ArrayList<String>();

    @BeforeClass
    public static void setup() {
    }

    @Before
    public void initList() {

        reservation1.add("Skoda");
        reservation1.add("VW");
        reservation2.add("Audi");
        reservation2.add("Mercedes");
        reservation3.add("Citroen");
        reservation3.add("Opel");
        reservation4.add("Peugeot");


        repository.collectionAccess().add(new UserReservation(1,reservation1));
        repository.collectionAccess().add(new UserReservation(2, reservation2));
        repository.collectionAccess().add(new UserReservation(3, reservation3));

    }


    @Test
    public void addReservedCars_correct() {
        int reservationCalculateBeforeAdd = repository.collectionAccess().size();
        crud.createUserReservation(new UserReservation(4, reservation4));
        Assert.assertEquals(reservationCalculateBeforeAdd + 1, repository.collectionAccess().size());
    }

    @Test
    public void getReservedCarsById_correct(){
        UserReservation reservation = crud.getReservationById((long) 1);
        Assert.assertEquals(reservation.getReservedCars(), reservation1);
    }

    @Test(expected = NoSuchElementException.class)
    public void getReservationById_NoSuchElementException_expected() {
        UserReservation reservation = crud.getReservationById((long) 10);
    }

    @Test
    public void deleteReservedCarsById_correct() {
        int elementBeforeTest = repository.collectionAccess().size();
        Assert.assertTrue(crud.deleteUserReservation((long) 1));
        Assert.assertEquals(elementBeforeTest, repository.collectionAccess().size() + 1);
    }

    @Test
    public void deleteReservedCars_no_element() {
        Assert.assertFalse(crud.deleteUserReservation((long) 10));
    }

    @Test
    public void getAllReservedCars_correct() {
        List<UserReservation> reservations = crud.getAllUserReservation();
        Assert.assertEquals(reservations.size(), 6);
    }
    @Test
    public void updateUserReservation_correct() {
        User user = new User((long)1,"Jan","Kowalski");
        UserReservation reservationToUpdate = crud.getReservationById((long) 1);
        user.setUserReservation(new UserReservation(1,reservation2));

        Assert.assertEquals(reservationToUpdate.getReservedCars(), reservationToUpdate.getReservedCars());
        Assert.assertEquals(reservationToUpdate.isDone(), reservationToUpdate.isDone());
    }

}