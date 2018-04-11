public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(10,10);
        for (int i = 0;i<14;i++){
            System.out.println(parking.park(new Car("small")));
            System.out.println(parking.park(new Car("big")));
        }
        System.out.println(parking.getFreeSpace());
        for (int i = 0;i<15;i++){
            System.out.println(parking.unPark(new Car("small")));
            System.out.println(parking.unPark(new Car("Big")));
        }
        System.out.println(parking.getFreeSpace());
    }
}
