package co.istad.oop.abstraction;

public class RoomOne implements IBuilding {
    private int roomNumber;

    public RoomOne(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void build() {
        System.out.println("Building Room One...");
    }
}
