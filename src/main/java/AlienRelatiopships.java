import java.util.HashMap;
import java.util.Map;

public class AlienRelatiopships {
    private Map<String, AlienRelationship> relations = new HashMap<String, AlienRelationship>();

    public AlienRelatiopships() {
    }

    public Map<String, AlienRelationship> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, AlienRelationship> relations) {
        this.relations = relations;
    }

    public void changeRelationship(String name, int delta) {

    }

    public void addRelationship(String name1, String Name2, int initialValue) {

    }
}
