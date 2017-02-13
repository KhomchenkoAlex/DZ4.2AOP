package car;

import car.autoparts.Engine;
import car.autoparts.SummerTyres;
import car.autoparts.Tyres;
import car.autoparts.Wheel;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"car"})
@Configuration
@PropertySource("classpath:car.properties")
public class ApplicationConfig {

    @Value("${car.tyreSize}")
    private int size;
    @Value("${car.tyreName}")
    private String name;
    @Value("${car.engineCapacity}")
    private int engineCapacity;
    @Value("${car.engineType}")
    private String engineType;


    @Bean(autowire = Autowire.BY_NAME)
    public SummerTyres summerTyres() {
        return new SummerTyres(size, name);
    }

    @Bean
    public Wheel wheel(Tyres summerTyres) {
        return new Wheel(summerTyres);
    }

    @Bean(autowire = Autowire.BY_NAME)
    public Engine engine() {
        return new Engine(engineCapacity, engineType);
    }

    @Bean(autowire = Autowire.BY_NAME)
    public Car car() {
        return new Car();
    }

    @Bean
    public CarAspect carAspect() {
        return new CarAspect();
    }

}
