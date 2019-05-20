package kingsGambit;

public abstract class Unit {
    private String name;

    protected Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
