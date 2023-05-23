package animal;

public class CatFamily {
    private int ears, legs;
    private boolean bigClaws;

    public CatFamily() {
        this(2, 4, true);
    }

    public CatFamily(int ears, int legs, boolean bigClaws) {
        setEars(ears);
        setLegs(legs);
        setBigClaws(bigClaws);
    }

    public int getEars() {
        return ears;
    }

    public final void setEars(int ears) {
        this.ears = ears;
    }

    public int getLegs() {
        return legs;
    }

    public final void setLegs(int legs) {
        this.legs = legs;
    }

    public boolean hasBigClaws() {
        return bigClaws;
    }

    public final void setBigClaws(boolean bigClaws) {
        this.bigClaws = bigClaws;
    }

    public void eat() {
        System.out.print("Eating ");
    }

    @Override
    public String toString() {
        return "Ears: " + ears +
               "\nLegs: " + legs +
               "\nBig claws: " + bigClaws;
    }
}
