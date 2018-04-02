package validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Correct {
    private List<Validator> list;
    private int flag;
    public Correct() {
        list=new ArrayList<>();
        list.add(new EngineValidator());
    }
    public int validator(Object object) throws IllegalAccessException {
        if(Objects.nonNull(object)){
            for(Validator validator:list){
                flag=validator.validater(object);
            }
        }
        return flag;
    }
}
