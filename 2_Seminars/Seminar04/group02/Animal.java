package group02;

public abstract class Animal {
    protected int distance;
    protected final String name;

    protected Animal(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public abstract void swim(int distance) throws AnimalSwimException;
    public abstract void run(int distance) throws AnimalRunException;
}
