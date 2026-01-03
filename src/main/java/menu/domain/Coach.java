package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> neverEatingFoods;

    public Coach(String name) {
        this.name = name;
        this.neverEatingFoods = null;
    }

    public String getName() {
        return this.name;
    }
}
