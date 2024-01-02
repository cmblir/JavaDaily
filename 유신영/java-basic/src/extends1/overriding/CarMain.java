package extends1.overriding;
import extends1.ex3.ElectricCar;
import extends1.ex3.GasCar;
public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();

        GasCar gasCar = new GasCar();
        gasCar.move();
    }
}
