package co.istad.oop.abstraction;

public interface IProcessor {
    default void start(){
        System.out.println("Processor is starting...");
    }
    static void stop(){
        System.out.println("Processor is stopping...");
    }
}
