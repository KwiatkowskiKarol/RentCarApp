package carrentproject;

import carrentproject.Model.User;
import carrentproject.Model.UserReservation;
import carrentproject.Model.UserReservationDate;
import carrentproject.Model.UserReservationList;
import carrentproject.Repo.DoRepo;
import carrentproject.Service.Crud;
import carrentproject.Service.Factory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)

public class CrudTest {
    private DoRepo repository = DoRepo.getInstance();
    private Crud crud = new Crud();

    @Mock
    private UserReservationDate userReservationDateMock;
    @Mock
    private Crud crudMock;
    @Mock
    private UserReservation reservationMock;

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
        Assert.assertEquals(reservations.size(), 29);
    }
    @Test
    public void updateUserReservation_correct() {
        User user = new User((long) 1,"Jan","Kowalski" , "123456789");
        UserReservation reservationToUpdate = crud.getReservationById((long) 1);
        user.setUserReservation(new UserReservation(1,reservation2));

        Assert.assertEquals(reservationToUpdate.getReservedCars(), reservationToUpdate.getReservedCars());
    }
    //Mock
    @Test
    public void readDateOnGetObject_correct() {
        LocalDateTime time = LocalDateTime.now();
        when(crudMock.getReservationById((long)1)).thenReturn(reservationMock);
        when(crudMock.getReservationById((long)1).getLastReadTime()).thenReturn(time);

        Assert.assertEquals(crudMock.getReservationById((long) 1).getLastReadTime(), time);
    }
    @Test
    public void getTimesByUserId_correct() {
        Assert.assertNotNull((crud.getReservationById((long)1)));
    }

    @Test
    public void addDataOverAddCollection_correct() {
        crud.createUserReservation(Factory.create((30),reservation5));
        LocalDateTime time = LocalDateTime.now();

        when(crudMock.getReservationById((long)30)).thenReturn(reservationMock);
        when(crudMock.getReservationById((long)30).getLastReadTime()).thenReturn(time);
        Assert.assertEquals(crudMock.getReservationById((long)30).getLastReadTime(), time);
    }
    @Test
    public void updateDateOverUpdateObject_correct() {
        LocalDateTime time = LocalDateTime.now();
        when (userReservationDateMock.getUpdateTime()).thenReturn(time);

        UserReservation reservation = crud.updateUser((long) 1, crud.getReservationById((long) 2));
        Mockito.timeout(300);
        Assert.assertEquals(userReservationDateMock.getUpdateTime(), time);
    }
    @Test
    public void setTimesSaveToFalse_correct() {
        UserReservation reservationWithFalse = repository.collectionAccess().get(1);
        reservationWithFalse.setRecordTimes(false);
        crud.updateUser(reservationWithFalse.getReservationId(), reservationWithFalse);
        Mockito.timeout(300);

        List<UserReservation> allUserReservation = crud.getAllUserReservation();
        Assert.assertEquals(3 , allUserReservation.stream().filter(x -> x.getLastReadTime() == reservationWithFalse.getLastReadTime()).count());
    }
}