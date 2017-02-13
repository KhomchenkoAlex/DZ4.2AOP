package car.autoparts;

import car.carexception.BrokenWheelException;

/**
 * Created by alex on 01.02.17.
 */
public class Wheel {
    protected Tyres tyres;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public String getTyres() {
        String res = tyres.getName() + " " + tyres.getSize() + "''" + tyres.getType();
        return res;
    }

    public void revolveWheels() throws BrokenWheelException {
        int rnd = (int) (Math.random() * 2);
        if (rnd == 1) throw new BrokenWheelException();
        System.out.println("The wheels revolving.");
    }
}
