package co.istad.oop.abstraction;

public class RoomTwo implements IBuilding {
    private int roomNumber;

    public RoomTwo(int roomNumber) {
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
        System.out.println("Building Room Two...");
    }
}
