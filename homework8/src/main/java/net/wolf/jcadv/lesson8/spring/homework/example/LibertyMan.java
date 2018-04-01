package net.wolf.jcadv.lesson8.spring.homework.example;

public class LibertyMan implements Liberty {
    @Override
    public void rank(int number) {
        System.out.printf("You have rank %s\n",number);
    }
}
