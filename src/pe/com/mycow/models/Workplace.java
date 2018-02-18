package pe.com.mycow.models;

public class Workplace {
    private int id;
    private String location;
    private String address;
    private User user;

    public Workplace() {
    }

    public Workplace(int id, String location, String address, User user) {
        this.id = id;
        this.location = location;
        this.address = address;
        this.user = user;
    }

    public int getId() {

        return id;
    }

    public Workplace setId(int id) {
        this.id = id;
        return this;
    }

    public String getLocation() {

        return location;
    }

    public Workplace setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getAddress(){
        return address;
    }

    public Workplace setAddress(String address){
        this.address = address;
        return this;
    }


    public User getUser() {
        return user;
    }

    public Workplace setUser(User user) {
        this.user = user;
        return this;
    }
}
