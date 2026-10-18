package parking.refactored;

public class BusTariff implements VehicleTariff{
    @Override
    public String name(){
        return "Bus";
    }
    @Override
    public double fee(int hours){
        return hours * 15.0;
    }
}
