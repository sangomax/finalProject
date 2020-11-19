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

    @Override
    public String toString() {
        return "Category{" +
                "nameCategory='" + nameCategory + '\'' +
                ", codeCategory=" + codeCategory +
                ", colorCategory='" + colorCategory + '\'' +
                '}';
    }
}
