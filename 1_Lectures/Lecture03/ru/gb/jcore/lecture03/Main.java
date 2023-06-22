package ru.gb.jcore.lecture03;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(); Cat cat2 = new Cat();
        cat1.name = "Barsik"; cat1.color = "white"; cat1.age = 4;
        cat2.name = "Murzik"; cat2.color = "black"; cat2.age = 6;

        System.out.println("Cat 1 name: " + cat1.name +
                            "; color: " + cat1.color + "; age: " + cat1.age);
        System.out.println("Cat 2 name: " + cat2.name +
                             "; color: " + cat2.color + "; age: " + cat2.age);

        cat1.jump();
        cat1.voice();
        cat2.jump();
        cat2.voice();

    }
}
