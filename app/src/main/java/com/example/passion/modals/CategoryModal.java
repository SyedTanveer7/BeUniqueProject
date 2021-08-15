package com.example.passion.modals;

import java.util.List;

public class CategoryModal {

    private List<InterestDataModal> interests;
    private String name;


    public List<InterestDataModal> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestDataModal> interests) {
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
