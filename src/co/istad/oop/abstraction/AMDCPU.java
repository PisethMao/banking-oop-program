package co.istad.oop.abstraction;

public class AMDCPU extends CPU {
    public AMDCPU(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("AMD CPU is starting...");
    }

    @Override
    public void stop() {
        System.out.println("AMD CPU is stopping...");
        super.stop();
    }
}
