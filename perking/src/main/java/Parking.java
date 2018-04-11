class Parking {
    private final int capcityForSmallCar;
    private final int capcityForBigCar;
    private int numberOfOccupiedPlacesForSmallCar = 0;
    private int numberOfOccupiedPlacesForBigCar = 0;


    Parking(int numFreeParkingSpaceForSmallCar, int numFreeParkingSpaceForBigCar) {
        this.capcityForSmallCar = numFreeParkingSpaceForSmallCar;
        this.capcityForBigCar = numFreeParkingSpaceForBigCar;
    }

    String park(Car car) {
        if (car.getSize().equalsIgnoreCase("small")) {
            if (numberOfOccupiedPlacesForSmallCar < 10 && numberOfOccupiedPlacesForSmallCar >= 0) {
                setNumberOfOccupiedPlacesForSmallCar(getNumberOfOccupiedPlacesForSmallCar() + 1);
                return "Car " + car.getClass().getSimpleName() + " is parked.";
            } else return "No free space " + car.getSize().toUpperCase();
        } else if (car.getSize().equalsIgnoreCase("big")) {
            if (numberOfOccupiedPlacesForBigCar < 10 && numberOfOccupiedPlacesForBigCar >= 0) {
                setNumberOfOccupiedPlacesForBigCar(getNumberOfOccupiedPlacesForBigCar() + 1);
                return "Car " + car.getClass().getSimpleName() + " is parked.";
            } else return "No free space for " + car.getSize().toUpperCase();
        } else return "Cant park car with unknown size = " + car.getSize();
    }

    String unPark(Car car) {
        if (car.getSize().equalsIgnoreCase("small")) {
            if (!(numberOfOccupiedPlacesForSmallCar <= 0)) {
                setNumberOfOccupiedPlacesForSmallCar(getNumberOfOccupiedPlacesForSmallCar() - 1);
                return "Car " + car.getClass().getSimpleName() + " is unparked.";
            } return "Free space for small car = " + (capcityForSmallCar - numberOfOccupiedPlacesForSmallCar) +
                    " Free space for big car = " + (capcityForBigCar - numberOfOccupiedPlacesForBigCar);
        } else if (car.getSize().equalsIgnoreCase("big")) {
            if (!(numberOfOccupiedPlacesForBigCar <= 0)) {
                setNumberOfOccupiedPlacesForBigCar(getNumberOfOccupiedPlacesForBigCar() - 1);
                return "Car " + car.getClass().getSimpleName() + " is unparked.";
            }return "Free space for small car = " + (capcityForSmallCar - numberOfOccupiedPlacesForSmallCar) +
                    " Free space for big car = " + (capcityForBigCar - numberOfOccupiedPlacesForBigCar);

        } else return "Cant unpark car with unknown size = " + car.getSize();
    }

    String getFreeSpace() {
        return "Free space for small car = " + (capcityForSmallCar - numberOfOccupiedPlacesForSmallCar) +
                " Free space for big car = " + (capcityForBigCar - numberOfOccupiedPlacesForBigCar);
    }

    //region getters and setters

    public int getNumberOfOccupiedPlacesForSmallCar() {
        return numberOfOccupiedPlacesForSmallCar;
    }

    public void setNumberOfOccupiedPlacesForSmallCar(int numberOfOccupiedPlacesForSmallCar) {
        this.numberOfOccupiedPlacesForSmallCar = numberOfOccupiedPlacesForSmallCar;
    }

    public int getNumberOfOccupiedPlacesForBigCar() {
        return numberOfOccupiedPlacesForBigCar;
    }

    public void setNumberOfOccupiedPlacesForBigCar(int numberOfOccupiedPlacesForBigCar) {
        this.numberOfOccupiedPlacesForBigCar = numberOfOccupiedPlacesForBigCar;
    }


    //endregion
}
