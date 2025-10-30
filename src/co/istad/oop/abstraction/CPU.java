package co.istad.oop.abstraction;

public abstract class CPU {
    protected String name;

    public abstract void start();

    public void stop() {
        System.out.println("CPU is stopped!");
    }
}
