package DesignPattern.Factory.method;

public class WulingFactory implements Factory{
    @Override
    public Car getCar() {
        return new Wuling();
    }
}
