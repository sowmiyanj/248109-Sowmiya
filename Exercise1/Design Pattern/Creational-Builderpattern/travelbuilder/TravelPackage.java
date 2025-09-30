package travelbuilder;

public class TravelPackage {
    private final String destination;
    private final String hotel;
    private final String transport;
    private final String meals;

    private TravelPackage(TravelPackageBuilder builder) {
        this.destination = builder.destination;
        this.hotel = builder.hotel;
        this.transport = builder.transport;
        this.meals = builder.meals;
    }

    public static class TravelPackageBuilder {
        private String destination;
        private String hotel;
        private String transport;
        private String meals;

        public TravelPackageBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public TravelPackageBuilder setHotel(String hotel) {
            this.hotel = hotel;
            return this;
        }

        public TravelPackageBuilder setTransport(String transport) {
            this.transport = transport;
            return this;
        }

        public TravelPackageBuilder setMeals(String meals) {
            this.meals = meals;
            return this;
        }

        public TravelPackage build() {
            if (destination == null || destination.isEmpty()) {
                throw new IllegalArgumentException("Destination must be specified!");
            }
            return new TravelPackage(this);
        }
    }

    @Override
    public String toString() {
        return "TravelPackage -> Destination: " + destination +
               ", Hotel: " + hotel +
               ", Transport: " + transport +
               ", Meals: " + meals;
    }
}
