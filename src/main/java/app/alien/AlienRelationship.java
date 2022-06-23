package app.alien;

/**
 * A class representing a relationship of two alien races.
 */
public class AlienRelationship {
    private String alienName1;
    private String alienName2;
    private int relationMeter;

    /**
     * @param alienName1 Name of the first alien of the relationship.
     * @param alienName2 Name of the second alien of the relationship.
     * @param relationMeter Initial value of the relationship.
     */
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

    /**
     * change relationship by a given value.
     * @param delta A given value.
     */
    public void changeRelationship(int delta) {
        this.relationMeter += delta;
    }
}