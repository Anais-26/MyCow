package pe.com.mycow.models;

public class Picture {
    private int id;
    private String name;

    public Picture(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Picture() {
    }

    public int getId() {
        return id;
    }

    public Picture setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Picture setName(String name) {
        this.name = name;
        return this;
    }
}
