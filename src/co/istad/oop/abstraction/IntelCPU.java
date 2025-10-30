package co.istad.oop.abstraction;

public class IntelCPU extends CPU {
    public IntelCPU(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("Intel CPU is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Intel CPU is stopping...");
        super.stop();
    }
}
