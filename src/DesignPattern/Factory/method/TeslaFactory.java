package DesignPattern.Factory.method;

public class TeslaFactory implements Factory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
