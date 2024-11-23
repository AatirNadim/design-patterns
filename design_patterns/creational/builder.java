package design_patterns.creational;


class Car {
    private String engineType;
    private String transmission;
    private boolean hasSunRoof;

    private Car(CarBuilder builder) {
        engineType = builder.engineType;
        transmission = builder.transmission;
        hasSunRoof = builder.hasSunRoof;
    }

    public void printDetails() {
        System.out.println("details");
    }

    public static class CarBuilder {
        private String engineType;
        private String transmission;
        private boolean hasSunRoof;

        public CarBuilder addEngine(String val) {
            this.engineType = val;
            return this;
        }

        public CarBuilder addTransmission(String val) {
            this.transmission = val;
            return this;
        }

        public CarBuilder sunroof(boolean val) {
            this.hasSunRoof = val;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

}


class Front {

    Car car;
    public void buildCar(String engine, String transmission, boolean sunroof) {
        car = new Car.CarBuilder().addEngine(engine).addTransmission(transmission).sunroof(sunroof).build();
    }
}