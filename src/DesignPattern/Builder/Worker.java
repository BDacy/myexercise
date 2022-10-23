package DesignPattern.Builder;

public class Worker extends Builder{
    private Product product;

    public Worker(){
        product=new Product();
    }
    @Override
    public Builder builderA(String msg) {
        product.setA(msg);
        return this;
    }

    @Override
    public Builder builderB(String msg) {
        product.setB(msg);
        return this;
    }

    @Override
    public Builder builderC(String msg) {
        product.setC(msg);
        return this;
    }

    @Override
    public Builder builderD(String msg) {
        product.setD(msg);
        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
