package DesignPattern.Facade;

public class Client {
    public static void main(String[] args) {
        Controller controller =new Controller(new Light(),new TVSystem());
        System.out.println("起床了");
        controller.open();
        System.out.println();
        System.out.println("睡觉了");
        controller.close();
    }
}
