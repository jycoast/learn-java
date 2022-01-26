package modules.overview;

public class VolatileDemo {

    private  volatile int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
