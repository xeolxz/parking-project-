package parking.refactored;


import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, VehicleTariff> tariffs = Map.of(
                "CAR", new CarTariff(),
                "MOTORBIKE", new MotorbikeTariff(),
                "TRUCK", new TruckTariff()
        );

        ParkingService garage = new ParkingService(
                new PaymentService(),
                new TextReportFormatter(),
                new FileLogger("parking_refactored.log")
        );

        Vehicle car = new Vehicle("12345-A-6", "CAR");
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK");

        PaymentMethod card = new CardPayment("4242");
        PaymentMethod cash = new CashPayment();

        garage.checkout(car, 3, card, tariffs.get("CAR"));
        garage.checkout(bike, 2, cash, tariffs.get("MOTORBIKE"));
        garage.checkout(truck, 4, card, tariffs.get("TRUCK"));

        garage.cancel(
                truck, 4, (RefundablePaymentMethod) card,
                tariffs.get("TRUCK"));

        System.out.println(garage.dailyReport());
    }
}
