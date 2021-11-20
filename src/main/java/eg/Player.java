package eg;

public class Player {
    public static int health = 100;

    private int healthPoint = 100;

    public void hit(int damage) {
        healthPoint -= damage;
        health -= damage;
    }

    public String getHealth() {
        return "self health = " + healthPoint +", common health = " + health;
    }

}
