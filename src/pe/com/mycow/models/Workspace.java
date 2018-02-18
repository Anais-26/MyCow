package pe.com.mycow.models;

public class Workspace {
    private int id;
    private String typeSpace;
    private String address;
    private int price;
    private String capacity;
    private String description;
    
    public Workspace(int id, String typeSpace, String address, int price, String capacity, String description) {
        this.id = id;
        this.typeSpace = typeSpace;
        this.address = address;
        this.price = price;
        this.capacity = capacity;
        this.description = description;
    }

    public Workspace() {
    }

    public int getId() {
        return id;
    }

    public Workspace setId(int id) {
        this.id = id;
        return this;
    }

    public String getTypeSpace() {
        return typeSpace;
    }

    public Workspace setTypeSpace(String typeSpace) {
        this.typeSpace = typeSpace;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Workspace setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Workspace setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getCapacity() {
        return capacity;
    }

    public Workspace setCapacity(String capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Workspace setDescription(String description) {
        this.description = description;
        return this;
    }

}
