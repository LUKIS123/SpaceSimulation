import java.util.HashMap;

public class AlienRelationships {
    private HashMap<String, HashMap<String, AlienRelationship>> relations = new HashMap<String, HashMap<String, AlienRelationship>>();

    public AlienRelationships() {
    }

    public HashMap<String, HashMap<String, AlienRelationship>> getRelations() {
        return relations;
    }

    public void setRelations(HashMap<String, HashMap<String, AlienRelationship>> relations) {
        this.relations = relations;
    }

    public void changeRelationship(String name1, String name2, int delta) {
        relations.get(name1).get(name2).changeRelationship(delta);
        relations.get(name2).get(name1).changeRelationship(delta);
    }

    public void addRelationship(String name1, String name2, int initialValue) {
        relations.get(name1).put(name2, new AlienRelationship(name1, name2, initialValue));
        relations.get(name2).put(name1, new AlienRelationship(name2, name1, initialValue));
    }

    public Boolean relationExists(String name1, String name2) {
        return relations.get(name1).get(name2) != null;
    }
}
