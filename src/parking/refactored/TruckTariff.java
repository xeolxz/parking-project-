package parking.refactored;

public class TruckTariff implements VehicleTariff{
    @Override
    public String name(){
        return "Truck";
    }
    @Override
    public double fee(int hours){
        return 20 + hours * 10.0;
    }
}
