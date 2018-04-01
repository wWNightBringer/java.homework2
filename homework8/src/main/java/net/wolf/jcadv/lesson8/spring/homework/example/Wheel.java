package net.wolf.jcadv.lesson8.spring.homework.example;

public class Wheel implements WheelSize {
    private Rubber rubber;

    public Wheel(Rubber rubber) {
        this.rubber = rubber;
    }

    @Override
    public int size(int wight) {
        rubber.showQuality();
        return wight;
    }
}
