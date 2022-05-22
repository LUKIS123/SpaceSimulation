import java.util.ArrayList;
import java.util.List;

public class AlienRace {
    static private List<String> usedNames = new ArrayList<String>();
    private String name;
    private int money;

    public AlienRace(String name, int money) {
        usedNames.add(name);
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
