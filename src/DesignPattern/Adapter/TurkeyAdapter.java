package DesignPattern.Adapter;

public class TurkeyAdapter implements Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void duck() {
        turkey.turkey();
    }
}
