package co.istad.oop.abstraction;

public class Processor implements IProcessor {
    @Override
    public void start() {
        System.out.println("Processor is starting...");
    }
}
