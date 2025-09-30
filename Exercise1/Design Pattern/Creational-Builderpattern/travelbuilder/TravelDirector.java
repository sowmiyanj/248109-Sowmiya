package travelbuilder;

public class TravelDirector {
    public TravelPackage buildLuxuryPackage() {
        return new TravelPackage.TravelPackageBuilder()
                .setDestination("Maldives")
                .setHotel("5-Star Resort")
                .setTransport("Business Flight")
                .setMeals("All Inclusive")
                .build();
    }

    public TravelPackage buildBudgetPackage() {
        return new TravelPackage.TravelPackageBuilder()
                .setDestination("Thailand")
                .setHotel("3-Star Hotel")
                .setTransport("Economy Flight")
                .setMeals("Breakfast Only")
                .build();
    }
}
