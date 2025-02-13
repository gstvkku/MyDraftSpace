package io.codeforall.bootcamp;

public class Playground {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("myLittleHotel", 2);
        Person person1 = new Person("Tobias");
        person1.visitHotel(hotel1);
        person1.makeCheckOut(hotel1);
        person1.makeCheckIn(hotel1);
        person1.makeCheckIn(hotel1);
        person1.makeCheckOut(hotel1);
    }
}
