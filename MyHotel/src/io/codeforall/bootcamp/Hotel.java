package io.codeforall.bootcamp;

public class Hotel {
    private String name;
    private Rooms[] allRooms;
    private int availableRooms;

    public Hotel(String name, int numberOfRooms) {
        this.name = name;
        this.availableRooms = numberOfRooms;
        this.allRooms = new Rooms[numberOfRooms];
        initiateArray(numberOfRooms);
        System.out.println("A new hotel was created!");
    }

    public void initiateArray(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            this.allRooms[i] = new Rooms(i + 1);
        }
    }

    public void hotelIntroduction() {
        System.out.println("Welcome to the hotel " + this.name + "! Here you are going to have good moments :)");
    }

    public int checkInVerification(String name, boolean isGuest, int personalRoom) {
        if (this.availableRooms == 0) {
            System.out.println("Sorry, " + name + " . We don't have available rooms :(");
            return personalRoom;
        } else if (isGuest == true) {
            System.out.println("Sorry, you are already checked in this hotel.");
            return personalRoom;
        }
        return occupyRoom(name, personalRoom);
    }

    public int occupyRoom(String name, int personalRoom) {
        int i = -1;
        for (i = 0; i < this.availableRooms; i++) {
            if (allRooms[i].getAvailable() == false) {
                continue;
            } else if (allRooms[i].getAvailable() == true) {
                allRooms[i].setIsRoomFree(false);
                this.availableRooms--;
                System.out.println("Welcome " + name + "! The number of your room is: " + (i + 1));
                break;
            }
        }
        return i + 1;
    }

    public int checkOutVerification(String name, int personalRoom, boolean isGuest) {
        if (isGuest == false) {
            System.out.println("You need to make the check in first!");
            return personalRoom;
        }
        allRooms[personalRoom - 1].setIsRoomFree(true);
        System.out.println("Thanks for the preference, " + name + "! Hope to see you again :)");
        return -1;
    }
}

