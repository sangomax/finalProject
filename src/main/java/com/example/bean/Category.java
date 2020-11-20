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
                setColorCategory("LightSkyBlue");
                setNameCategory("Geography");
                break;
            case 2:
                setCodeCategory(code);
                setColorCategory("LightPink");
                setNameCategory("Entertainment");
                break;
            case 3:
                setCodeCategory(code);
                setColorCategory("Yellow");
                setNameCategory("History");
                break;
            case 4:
                setCodeCategory(code);
                setColorCategory("MediumPurple");
                setNameCategory("Art & Culture or Art & Culture");
                break;
            case 5:
                setCodeCategory(code);
                setColorCategory("LightGreen");
                setNameCategory("Science & Nature");
                break;
            case 6:
                setCodeCategory(code);
                setColorCategory("Orange");
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
