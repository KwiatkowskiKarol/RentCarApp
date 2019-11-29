package carrentproject.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import carrentproject.Model.CarReservation;
import carrentproject.Service.Crud;

@RestController
@RequestMapping("/api")

public class CarReservationApi {
    private Crud crud;

    @Autowired
    public CarReservationApi(Crud crud){
        this.crud = crud;
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> createCarReservation(@RequestBody CarReservation carReservation){
        return ResponseEntity.ok(crud.createCarReservation(carReservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarReservation> getReservationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(crud.getReservationById(id));
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCarReservation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(crud.deleteCarReservation(id));
    }

    @PutMapping
    public ResponseEntity<CarReservation> updateCarReservation(@PathVariable("id") Long id, @RequestBody CarReservation carReservation){
        return ResponseEntity.ok(crud.updateCar(id, carReservation));
    }
}
