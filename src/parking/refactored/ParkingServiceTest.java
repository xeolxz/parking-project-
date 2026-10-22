package parking.refactored;

public class ParkingServiceTest {
    public static void main(String[] args) throws Exception {
        ParkingService service = new ParkingService(
                new PaymentService(),
                new TextReportFormatter(),
                new FakeLogger()
        );

        Vehicle car = new Vehicle("12345-A-6", "CAR");
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK");

        VehicleTariff carTariff = new CarTariff();
        VehicleTariff bikeTariff = new MotorbikeTariff();
        VehicleTariff truckTariff = new TruckTariff();

        check(service.fee(car, 3, carTariff), 15.0);
        check(service.fee(bike, 2, bikeTariff), 4.0);
        check(service.fee(truck, 4, truckTariff), 60.0);

        service.checkout(car, 3, new CardPayment("4242"), carTariff);
        service.checkout(bike, 2, new CashPayment(), bikeTariff);
        service.checkout(truck, 4, new CardPayment("4242"), truckTariff);

        service.cancel(truck, 4, new CardPayment("4242"), truckTariff);

        String report = service.dailyReport();

        if (!report.endsWith("Total: 19.0 MAD")) {
            throw new AssertionError("Unexpected report:\n" + report);
        }

        System.out.println("All tests passed.");
    }

    private static void check(double actual, double expected) {
        if (Math.abs(actual - expected) > 1e-9) {
            throw new AssertionError(
                    "Expected " + expected + ", got " + actual
            );
        }
    }
}