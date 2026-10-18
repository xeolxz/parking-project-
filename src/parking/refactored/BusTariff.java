package parking.refactored;

public class BusTariff implements VehicleTariff{
    public String name(){
        return "Bus";
    }
    public double fee(int hours){
        return hours * 15.0;
    }
}
