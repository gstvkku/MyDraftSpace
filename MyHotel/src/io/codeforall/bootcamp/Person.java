package io.codeforall.bootcamp;

public class Person {
    private String name;
    public int personalRoom = -1;
    public boolean isGuest = false;

    public Person(String name) {
        this.name = name;
    }

    public void makeCheckIn(Hotel hotel) {
       this.personalRoom = hotel.checkInVerification(this.name, this.isGuest, this.personalRoom);
       if (this.isGuest == false) {
           this.isGuest = true;
       }
    }

    public void makeCheckOut(Hotel hotel) {
        this.personalRoom = hotel.checkOutVerification(this.name, this.personalRoom, this.isGuest);
        if (this.isGuest == true) {
            this.isGuest = false;
        }
    }

    public void visitHotel(Hotel hotel) {
        hotel.hotelIntroduction();
    }
}
