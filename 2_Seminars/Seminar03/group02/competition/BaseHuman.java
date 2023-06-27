package group02.competition;

public abstract class BaseHuman {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public BaseHuman() {
        name = "noname";
    }*/

    public BaseHuman(String name) {
        this.name = name;
    }

    abstract String displayInfo();
}
