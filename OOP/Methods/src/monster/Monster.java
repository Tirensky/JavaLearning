package monster;

public class Monster {
    private int eyes, arms, legs;

    public Monster() {
        this(2, 2, 2);
    }

    public Monster(int eyes) {
        this(eyes, 2, 2);
    }

    public Monster(int eyes, int arms) {
        this(eyes, arms, 2);
    }

    public Monster(int eyes, int arms, int legs) {
        this.eyes = eyes;
        this.arms = arms;
        this.legs = legs;
    }

    public void voice() {
        voice(1, null);
    }

    public void voice(int i) {
        voice(i, null);
    }

    public void voice(int i, String word) {
        for (int j = 0; j < i; j++) {
            System.out.print(say(word));
            if (j != i - 1) System.out.print(", ");
        }
        System.out.println(".");
    }

    private String say(String s) {
        return s == null ? "Voice" : s;
    }
}
