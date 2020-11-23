package com.example.bean;

public class Category {

    private String nameCategory;

    private Integer codeCategory;

    private String colorCategory;

    public Category(String nameCategory, Integer codeCategory, String colorCategory) {
        this.nameCategory = nameCategory;
        this.codeCategory = codeCategory;
        this.colorCategory = colorCategory;
    }

    public Category() {
        this.nameCategory = new String();
        this.codeCategory = new Integer(0);
        this.colorCategory = new String();
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Integer getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(Integer codeCategory) {
        this.codeCategory = codeCategory;
    }

    public String getColorCategory() {
        return colorCategory;
    }

    public void setColorCategory(String colorCategory) {
        this.colorCategory = colorCategory;
    }

    public void setCategory(Integer code) {
        switch (code) {
            case 1:
                setCodeCategory(code);
                setColorCategory("#1563BF");
                setNameCategory("Geography");
                break;
            case 2:
                setCodeCategory(code);
                setColorCategory("#D320D3");
                setNameCategory("Entertainment");
                break;
            case 3:
                setCodeCategory(code);
                setColorCategory("#F0BF2B");
                setNameCategory("History");
                break;
            case 4:
                setCodeCategory(code);
                setColorCategory("#6E22F0");
                setNameCategory("Art & Culture");
                break;
            case 5:
                setCodeCategory(code);
                setColorCategory("#128B6E");
                setNameCategory("Science & Nature");
                break;
            case 6:
                setCodeCategory(code);
                setColorCategory("#EA7620");
                setNameCategory("Sport & Leisure");
                break;
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "nameCategory='" + nameCategory + '\'' +
                ", codeCategory=" + codeCategory +
                ", colorCategory='" + colorCategory + '\'' +
                '}';
    }
}
