package co.istad.oop.abstraction;

public interface IInterface extends IProcessor {
    @Override
    default void start() {
        System.out.println("IInterface start");
    }
}
