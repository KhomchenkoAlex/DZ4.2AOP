package car;

import car.autoparts.Engine;
import car.carexception.BrokenWheelException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 10.02.17.
 */
@Aspect
@Component
public class CarAspect {

    @Before("execution(* car.Car.startCar(..))")
    public void beforeStartCar() {
        System.out.println("Start engine!");
    }

    @After("execution(* car.autoparts.Engine.startEngine(..))")
    public void afterStopCar(JoinPoint jointPoint) {
        Engine target = (Engine) jointPoint.getTarget();
        System.out.println(target.getEngineType() + " is working.");
    }

    @Before("execution(* car.autoparts.Engine.stopEngine())")
    public void beforeStopCar() {
        System.out.println("Stop engine!");
    }

    @Around("execution(* car.autoparts.Wheel.revolveWheels())")
    public void aroundRevolveWheels(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Shee-shee!");
        joinPoint.proceed();
        System.out.println("Shee-shee!");
    }

    @AfterThrowing(pointcut = "execution(* car.autoparts.Wheel.revolveWheels())", throwing = "bwe")
    public void afterThrowException(BrokenWheelException bwe) {
        System.out.println("You must repair the broken wheel!");
    }

}
