package pe.com.mycow.beans;

import com.sun.jdo.spi.persistence.support.sqlstore.connection.ConnectionImpl;
import org.apache.tools.ant.types.spi.Service;
import org.jboss.weld.context.RequestContext;
import pe.com.mycow.models.MycowService;
import pe.com.mycow.models.User;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.management.Query;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.apache.tools.ant.taskdefs.SetPermissions.NonPosixMode.pass;

@Named
@SessionScoped

public class UsersBean implements Serializable {

    private MycowService service;
    private User user;

    public UsersBean() {

        service = new MycowService();
    }

    public List<User> getUsers() {

        return service.findAllUsers();
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public String getName() {

        return this.getUser().getName();
    }

    public void setName(String name) {

        this.getUser().setName(name);
    }

    public String getLastName() {

        return this.getUser().getLastName();
    }

    public void setLastName(String lastName) {

        this.getUser().setLastName(lastName);
    }

    public String getPassword() {

        return this.getUser().getPassword();
    }

    public void setPassword(String password) {

        this.getUser().setPassword(password);
    }

    public String getEmail() {

        return this.getUser().getEmail();
    }

    public void setEmail(String email) {

        this.getUser().setEmail(email);
    }

    public int getAge() {

        return this.getUser().getAge();
    }

    public void setAge(int age) {

        this.getUser().setAge(age);
    }

    public int getDni() {

        return this.getUser().getDni();
    }

    public void setDni(int dni) {

        this.getUser().setDni(dni);
    }

    public String editUser(User user) {
        this.setUser(user);
        return "success";
    }

    public String newUser() {
        this.setUser(new User());
        return "success";
    }

    public String createUser() {
        service.createUser(this.getName(), this.getLastName(),
                this.getPassword(), this.getEmail(), this.getAge(), this.getDni());
        return "success";
    }

    public String updateUser() {
        service.updateUser(this.getUser());
        return "success";
    }

    /*
        public String deleteUser(User user){
            service.deleteUser(user.getId());
            return "success";
        }

    */
/*
    public String doValidateInput() throws Exception{

        if(!user.setPassword().equals(user.getPassword())) return "error";
        return "success";
    }
*/
    public String doValidateInput (){
        if(!"saxmple".equals(getPassword())) return "error";
        return "success";
    }

/*
    public void validate (FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String password = (String)value;
        if(!password.equalsIgnoreCase(getPassword())){
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Password No Valida") );
        }
    }

public User LogIn(User user){
    User us = null;
    String consulta;
    try{

        consulta = "SELECT u FROM users u.email = ?1 and u.password = ?1";
        Query query = service.createQuery(consulta);
        query.setParameter(1, user.getEmail());
        query.setParameter(2, user.getPassword());

        List<User> lista = query.getResultList();
        if(!lista.isEmpty()){
            email = lista.get(0);
        }

    }
    catch (Exception e){
        throw e;
    }
    finally {

    }
    return user;
}

    public String login() throws SQLException {
        if (loginValidation()) {
            return "success";
        } else {
            FacesContext.getCurrentInstance().addMessage("forma1", new FacesMessage("Datos Incorrectos"));
            return "incorrect";
        }

    }

    private  boolean loginValidation() throws SQLException{
        MycowService service = new MycowService();
        Statement Sentencias = null;
        ResultSet resultSet = null;
        Sentencias= service.getConnection().createStatement();
        resultSet = Sentencias.executeQuery("SELECT * FROM users WHERE email='"+getEmail()+"' AND password='"+getPassword()+"'");
        return false;
    }

    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.removeAttribute("usersBean");
        return "cerrar";
    }
*/
}











