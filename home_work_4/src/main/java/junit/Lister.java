package junit;

import java.util.ArrayList;
import java.util.List;

public class Lister {
    private List<Employeer> list;
    private Employeer employeer;
    public Lister() {
        list = new ArrayList<>();
        list.add(new Employeer("Andrew",21));
        list.add(new Employeer("Jack",30));
        list.add(new Employeer("John",50));
    }

    public List<Employeer> getList() {
        return list;
    }

}
