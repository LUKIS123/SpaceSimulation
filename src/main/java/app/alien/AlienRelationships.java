package app.alien;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing a relationship of every alien race.
 */
public class AlienRelationships {
    private Map<String, Map<String, AlienRelationship>> relations = new HashMap<>();

    public AlienRelationships() {
    }

    public Map<String, Map<String, AlienRelationship>> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, Map<String, AlienRelationship>> relations) {
        this.relations = relations;
    }

    /**
     * Change a relationship by a given value.
     * @param name1 Name of the first alien of the relationship.
     * @param name2 Name of the second alien of the relationship.
     * @param delta Amount to change the relationship meter.
     */
    public void changeRelationship(String name1, String name2, int delta) {
        relations.get(name1).get(name2).changeRelationship(delta);
        relations.get(name2).get(name1).changeRelationship(delta);
    }

    /**
     * Add a relationship to the relationships list.
     * @param name1 Name of the first alien of the relationship.
     * @param name2 Name of the second alien of the relationship.
     * @param initialValue Initial value of the relationship.
     */
    public void addRelationship(String name1, String name2, int initialValue) {
        Map<String, AlienRelationship> alienRelations = relations.get(name1);
        if (alienRelations == null) {
            relations.put(name1, new HashMap<String, AlienRelationship>());
        }
        alienRelations = relations.get(name2);
        if (alienRelations == null) {
            relations.put(name2, new HashMap<String, AlienRelationship>());
        }
        relations.get(name1).put(name2, new AlienRelationship(name1, name2, initialValue));
        relations.get(name2).put(name1, new AlienRelationship(name2, name1, initialValue));
    }

    /**
     * @param name1 Name of the first alien of the relationship.
     * @param name2 Name of the second alien of the relationship.
     * @return Returns true if a relationship exists, otherwise false.
     */
    public Boolean relationExists(String name1, String name2) {
        Map<String, AlienRelationship> alienRelations = relations.get(name1);
        if (alienRelations == null)
            return false;
        return alienRelations.get(name2) != null;
    }
}