package ua.nure.entity;

public class Country {
    private String name;
    private int creationYear;
    private float area;

    public Country() {
    }

    public Country(String name, int creationYear, float area) {
        this.creationYear = creationYear;
        this.name = name;
        this.area = area;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
}
