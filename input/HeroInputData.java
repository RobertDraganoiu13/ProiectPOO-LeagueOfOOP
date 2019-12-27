package input;

public final class HeroInputData {
    private char type;
    private int x;
    private int y;

    public char getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public HeroInputData(final char type, final int x, final int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
}
