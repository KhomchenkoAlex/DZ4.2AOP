package car.autoparts;

/**
 * Created by alex on 01.02.17.
 */

public class Engine {

    private String engineType;
    private int engineCapacity;

    public Engine(int engineCapacity, String engineType) {
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public String getEngineType() {
        return engineType;
    }

    public void startEngine() {
        System.out.println("Engine started.");
    }

    public void stopEngine() {
        System.out.println("Engine stoped.");
    }


}
