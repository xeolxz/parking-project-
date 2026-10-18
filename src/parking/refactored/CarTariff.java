package parking.refactored;

public class CarTariff implements VehicleTariff {
    public String name(){
        return "Car";
    }
    public double fee(int hours){
        return hours * 5.0;
    }
}
