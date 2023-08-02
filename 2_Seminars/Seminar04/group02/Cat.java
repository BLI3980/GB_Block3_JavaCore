package group02;

public class Cat extends Animal{
    public Cat(String name, int distance) {
        super(name, distance);
    }

    /**
     *
     * @param distance
     * @throws AnimalSwimException
     */
    @Override
    public void swim(int distance) throws AnimalSwimException {
        throw new AnimalSwimException("Cat cannot swim.", name, distance);
    }

    /**
     *
     * @param distance
     * @throws AnimalRunException
     */
    @Override
    public void run(int distance) throws AnimalRunException {
        if (distance < this.distance) {
            this.distance -= distance;
        } else {
            throw new AnimalRunException("Cat cannot run that far. ", name, distance);
        }
    }

}
