package parking.refactored;

public class TruckTariff implements VehicleTariff{
    public String name(){
        return "Truck";
    }
    public double fee(int hours){
        return 20 + hours * 10.0;
    }
}
