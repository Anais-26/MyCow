package pe.com.mycow.beans;

import pe.com.mycow.models.MycowService;
import pe.com.mycow.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UsersBean implements Serializable {
    private MycowService service;
    private User user;

    public UsersBean(){
        service = new MycowService();
    }

    public List<User> getUsers(){
        return service.findAllUsers();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName(){
        return this.getUser().getName();
    }

    public void setName(String name){
        this.getUser().setName(name);
    }

    public String editUser(User user){
        this.setUser(user);
        return "success";
    }
    public String newUser(){
        this.setUser(new User());
        return "success";
    }
    public  String createUser(){
        service.createUser(this.getName());
        return "success";
    }
    public String updateUser(){
        service.updateUser(this.getUser());
        return "success";
    }

    public String deleteUser(User user){
        service.deleteUser(user.getId());
        return "success";
    }
}
