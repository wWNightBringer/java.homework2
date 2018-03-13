package junit;

public class MathFunc {
    int calls;
    private Lister lister;

    public MathFunc() {
        lister=new Lister();
    }

    public int getCalls() {
        return calls;
    }
    public long fuctorial(int number) throws IllegalAccessException {
        calls++;
        if(number<0){
            throw new IllegalAccessException();
        }
       if(number==1 || number<1){
            return 1;
       }
        return number*fuctorial(number-1);

    }
    public long plus(int x,int y){
        calls++;
        return x+y;
    }
    public int countEmployeer(){
        System.out.println(lister.getList().size());
        return lister.getList().size();
    }
}
