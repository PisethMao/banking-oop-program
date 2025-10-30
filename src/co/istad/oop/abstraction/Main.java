package co.istad.oop.abstraction;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new IntelCPU("Intel");
        cpu.start();
        cpu.stop();
        System.out.println("========================================");
        cpu = new AMDCPU("AMD");
        cpu.start();
        cpu.stop();
        System.out.println("========================================");
        RoomOne roomOne = new RoomOne(1);
        roomOne.build();
        System.out.println("========================================");
        RoomTwo roomTwo = new RoomTwo(2);
        roomTwo.build();
        System.out.println("========================================");
        Processor processor = new Processor();
        processor.start();
    }
}
