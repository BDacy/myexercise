package DesignPattern.prototype;

public class ConcretePrototype extends ProtoType{
    private String filed;
    public ConcretePrototype(String filed){
        this.filed=filed;
    }

    @Override
    ProtoType myClone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}
