package DesignPattern.Factory.method;
//工厂方法模式
public class Consumer {
    public static void main(String[] args) {
        Car car = new WulingFactory().getCar();
        Car car1 = new TeslaFactory().getCar();
        car.name();
        car1.name();
    }
}
