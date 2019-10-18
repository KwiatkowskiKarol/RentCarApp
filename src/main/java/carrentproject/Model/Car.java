package carrentproject.Model;

public class Car {
    private int id;
    private String carBrand, carModel;
    private double carPrice;

    public int id(){
        return id;
    }
    public String getCarType(){
        return carBrand;
    }
    public String getCarModel(){
        return carModel;
    }
    public double getCarPrice(){
        return carPrice;
    }
    public String getCar(){
        return getCarType() + getCarModel();
    }
}