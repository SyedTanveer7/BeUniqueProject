package com.example.bio.modals;

public class BasicInfoData {
    private boolean premium;
    private String id;
    private BasicInfoData.key key;
    private String value;


    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BasicInfoData.key getKey() {
        return key;
    }

    public void setKey(BasicInfoData.key key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public class key {
        private String id;
        private String name;
        private String selection;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSelection() {
            return selection;
        }

        public void setSelection(String selection) {
            this.selection = selection;
        }
    }

}
