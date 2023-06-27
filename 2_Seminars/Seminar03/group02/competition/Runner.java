package group02.competition;

public interface Runner {
    int getMaxJump();
    int getMaxRun();
    String getName();

    default boolean jump(int height) {
        if (height <= getMaxJump()) {
            System.out.printf("%s jumped over the wall %d cm\n", getName(), height);
            return true;
        } else {
            System.out.printf("%s could not jump over the wall %d cm, stayed in place\n", getName(), height);
            return false;
        }
    }


    default boolean run(int length) {
        if (length <= getMaxRun()) {
            System.out.printf("%s run %d m distance\n", getName(), length);
            return true;
        } else {
            System.out.printf("%s could not run %d m distance, " +
                    "could run %d m\n", getName(), length, getMaxRun());
            return false;
        }
    }
}
