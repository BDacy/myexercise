package DesignPattern.Builder;

public class Product {
    private String A="汉堡";
    private String B="科了";
    private String C="薯条";
    private String D="hh";

    @Override
    public String toString() {
        return "Product{" +
                "A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                '}';
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }
}
