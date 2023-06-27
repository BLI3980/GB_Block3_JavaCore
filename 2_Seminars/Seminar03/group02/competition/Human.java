package group02.competition;

public class Human extends BaseHuman implements Runner{
    private int maxRun;
    private int maxJump;

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    // Initializer. Needed when there are many fields in the class
    {
        System.out.println("Initializer");
        name = "noname";
        this.maxJump = 100;
        this.maxRun = 1000;
    }



    public Human() {
        this("noname");
        /*this.name = "noname";
        this.maxRun = 1000;
        this.maxJump = 100;*/

    }

    public Human(String name) {
        this(name, 1000);
        /*this.name = name;
        this.maxRun = 1000;
        this.maxJump = 100;*/
    }

    public Human(String name, int maxRun) {
        this(name, maxRun, 100);
        /*this.name = "noname";
        this.maxRun = maxRun;
        this.maxJump = maxJump;*/
    }

    public Human(String name, int maxRun, int maxJump) {
        super(name);
        System.out.println("Constructor");
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    String displayInfo() {
        return String.format("Name: %s", name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }

}
