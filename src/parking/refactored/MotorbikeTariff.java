package parking.refactored;

public class MotorbikeTariff implements VehicleTariff{
    public String name(){
        return "Motorbike";
    }
    public double fee(int hours){
        return hours * 2.0;
    }
}
