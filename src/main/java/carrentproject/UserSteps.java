package carrentproject;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

import carrentproject.Model.Car;
import com.sun.org.apache.xerces.internal.util.PropertyState;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

    public class UserSteps {

        private Car car = new Car();

        @Given("^that the car (.*) is given a task to clear (.*) reservation car$")
        public void CarReservation(String CarType, String userReservation) throws Throwable {
            car.setCarType(CarType);
            car.setCarReservation(userReservation);
        }

        @When("^(.*) got (\\d+) reservation id$")
        public void gotReservationId(String CarType, int reservationId) throws Throwable {
            car.setCarType(CarType);
            car.setReservationId(reservationId);
        }

        @Then("^(.*) is known as (.*) reserved$")
        public void reservedYes(String name) throws Throwable {
            assertEquals(name, is(car.getCarType()));
            assertEquals(car.getCarReservation(), equalTo("Java"));
            assertEquals(car.isReserved(), is(true));
        }
    }