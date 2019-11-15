package carrentproject;
    import carrentproject.Model.DeleteCarReservation;
    import cucumber.api.java.en.Given;
    import cucumber.api.java.en.Then;
    import cucumber.api.java.en.When;
    import org.hamcrest.MatcherAssert;
    import carrentproject.Model.CarReservation;
    import carrentproject.Repo.DoRepo;
    import carrentproject.Service.Crud;

    import java.util.ArrayList;
    import java.util.List;

    import static org.hamcrest.CoreMatchers.equalTo;


public class Cucumber {

    private Crud crud = new Crud();
    private DoRepo repository = DoRepo.getInstance();

    private CarReservation carReservation;
    private DeleteCarReservation deleteCarReservation;

    private boolean isRemoved;

    private List<DeleteCarReservation> deleteCarReservations = new ArrayList<>();
    private List<CarReservation> carReservations = new ArrayList<>();

    //Create
    @Given("^Create New Car Reservation$")
    public void reservationIsDone() {
        carReservation = new CarReservation();
    }

    @When("^reservation get own cars (.*)$")
    public void setReservedCars(ArrayList<String> reservedCars) {
        carReservation.setReservedCars(reservedCars);
    }

    @Then("^user can show (.*)$")
    public void reservedCarsIsCorrect(ArrayList<String> reservedCars) {
        MatcherAssert.assertThat(carReservation.getReservedCars(), equalTo(reservedCars));
    }


    //Delete
    @Given("^Delete car reservation (.*)$")
    public void deleteCarReservation(ArrayList<String> deletedCars) { deleteCarReservation = new DeleteCarReservation(deletedCars);}

    @When("^car reservation got own id$")
    public void carReservationGotOwnId() { crud.getAllCarReservation(); }

    @Then("^user can delete reservation$")
    public void userCanDeleteReservation( ){ deleteCarReservation = new DeleteCarReservation(); }
}