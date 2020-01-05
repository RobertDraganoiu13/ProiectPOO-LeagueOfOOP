package input;

public final class AngelInputData {
    private String type;
    private int x;
    private int y;

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public AngelInputData(final String allData) {
        // parse data and initialize variables
        String[] parsed = allData.split(",");
        int i = 0;
        this.type = parsed[i++];
        this.x = Integer.parseInt(parsed[i++]);
        this.y = Integer.parseInt(parsed[i++]);
    }
}
