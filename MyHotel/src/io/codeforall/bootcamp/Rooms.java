package io.codeforall.bootcamp;

public class Rooms {
    public int roomId;
    private boolean available;

    public Rooms(int ID) {
        this.roomId = ID;
        this.available = true;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setIsRoomFree(boolean isRoomFree) {
        this.available = isRoomFree;
    }
}
