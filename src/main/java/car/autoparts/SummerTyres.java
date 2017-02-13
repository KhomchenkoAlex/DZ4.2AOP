package car.autoparts;

/**
 * Created by alex on 01.02.17.
 */
public class SummerTyres extends Tyres {

    private int size;
    private String name;
    private String type = "summer";

    public SummerTyres(int size, String name){
        this.size = size;
        this.name = name;
    }
    public int getSize(){
        return size;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
}
