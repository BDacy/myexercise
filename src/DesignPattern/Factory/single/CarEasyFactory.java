package DesignPattern.Factory.single;
//简单工厂模式，静态工厂模式
public class CarEasyFactory {
    public static Car getCar(String car){
        //方法一
        if (car.equals("五菱")){
            return new Wuling();
        }else if (car.equals("特斯拉")){
            return new Tesla();
        }else {
            return null;
        }
    }
    //方法二 想要什么就用什么
    public static Car getwuling(){
        return new Wuling();
    }
    public static Car getTesla(){
        return new Tesla();
    }
}
