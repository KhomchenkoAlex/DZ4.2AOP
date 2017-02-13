package car;

import car.autoparts.Engine;
import car.autoparts.Wheel;
import car.carexception.BrokenWheelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 01.02.17.
 */
@Component
public class Car {
    Wheel wheel;
    Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Autowired
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void startCar() {
        engine.startEngine();
        System.out.println("The car moves.");
        try {
            wheel.revolveWheels();
        } catch (BrokenWheelException bwe) {
            System.out.println("You broke the wheel.");
        }
    }

    public void stopCar() {
        engine.stopEngine();
        System.out.println("The car stops.");
    }

    public String carToString() {
        String res = "This car has ";
        res = res + engine.getEngineCapacity() + "cc engine capacity and wheels with " + wheel.getTyres() + " tyres.";
        return res;
    }
}
