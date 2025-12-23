package constants;

public class GameConstants {

    private static int createdCount = 0;
    public static final int MAX_LEVEL = 18;

    public static void addCreatedCount() {
        createdCount++;
    }

    public static int getCreatedCount() {
        return createdCount;
    }
}
