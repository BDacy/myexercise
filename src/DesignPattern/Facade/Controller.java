package DesignPattern.Facade;

public class Controller {
    private Light light;
    private TVSystem tvSystem;

    public Controller(Light light, TVSystem tvSystem) {
        this.light = light;
        this.tvSystem = tvSystem;
    }
    public void open(){
        System.out.println("打开电器");
        light.on();
        tvSystem.on();
    }
    public void close(){
        System.out.println("关闭电器");
        light.off();
        tvSystem.off();
    }
}
