package net.wolf.jcadv.lesson8.spring.homework.example;

public class MyCar implements CarRepository {
    private Wheel wheel;

    public MyCar(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public int move(int speed) {
        return speed;
    }

    @Override
    public void sound(String voice) {
        System.out.printf("Your voice hear like %s, and speed %s", voice,move(20));
        wheel.size(30);
    }
}
