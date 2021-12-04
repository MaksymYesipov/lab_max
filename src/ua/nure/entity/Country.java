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

    public String getName() {
        return name;
    }

    public float getArea() {
        return area;
    }

    @Override
    public String toString() {
        return name + ", founded in " + creationYear + ", area: " + area;
    }
}
