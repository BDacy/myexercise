package DesignPattern.Builder;

public abstract class Builder {
    public abstract Builder builderA(String msg);
    public abstract Builder builderB(String msg);
    public abstract Builder builderC(String msg);
    public abstract Builder builderD(String msg);

    public abstract Product getProduct();

}
