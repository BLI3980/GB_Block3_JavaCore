package group02.competition;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Human1");
        System.out.println(human1);

        BaseHuman human2 = new Human("Human2");
        System.out.println(human2);

        Runner human3 = new Human("Human3");
        System.out.println(human3);

        Runner[] runners = {
                new Cat("Cat1", 1500, 300),
                new Cat("Cat2", 1800, 380),
                new Robot("Robot1", 2000, 500),
                new Robot("Robot2", 2500, 10),
                new Human("Human1", 15000, 100),
                new Human("Human2", 7000, 300)
        };

        Obstacle[] obstacles = {
                new Track(1200),
                new Wall(30),
                new Track(1500),
                new Wall(140),
                new Track(3000),
                new Wall(300),
        };

        for (Runner runner: runners) {
            for (Obstacle obstacle: obstacles) {
                if (obstacle instanceof Track) {
                    if (!runner.run(obstacle.getLength()))
                        break;
                } else if (obstacle instanceof Wall) {
                    if (!runner.jump(obstacle.getHeight()))
                        break;
                }
            }
            System.out.println();
        };

    }
}
