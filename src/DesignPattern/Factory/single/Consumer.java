package DesignPattern.Factory.single;

public class Consumer {
    public static void main(String[] args) {
        //简单实现
        Car car =new Wuling();
        Car car1 =new Tesla();
        car.name();
        car1.name();
        //简单工厂实现
        Car car2 = CarEasyFactory.getCar("五菱");
        car2.name();
        Car car3 = CarEasyFactory.getCar("特斯拉");
        car3.name();

        Car car4 = CarEasyFactory.getwuling();
        Car car5 = CarEasyFactory.getTesla();
        car4.name();
        car5.name();
    }
}
