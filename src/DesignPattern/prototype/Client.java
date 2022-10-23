package DesignPattern.prototype;

public class Client {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype("abd");
        ProtoType clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}
