package app.alien;

public class AlienRelationship {
    private String alienName1;
    private String alienName2;
    private int relationMeter;

    public AlienRelationship(String alienName1, String alienName2, int relationMeter) {
        this.alienName1 = alienName1;
        this.alienName2 = alienName2;
        this.relationMeter = relationMeter;
    }

    public String getAlienName1() {
        return alienName1;
    }

    public void setAlienName1(String alienName1) {
        this.alienName1 = alienName1;
    }

    public String getAlienName2() {
        return alienName2;
    }

    public void setAlienName2(String alienName2) {
        this.alienName2 = alienName2;
    }

    public int getRelationMeter() {
        return relationMeter;
    }

    public void setRelationMeter(int relationMeter) {
        this.relationMeter = relationMeter;
    }

    public void changeRelationship(int delta) {
        this.relationMeter += delta;
    }
}
