package pe.com.mycow.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MycowService {

    private Connection connection;
    private UsersEntity usersEntity;
  /*  private WorkspacesEntity workspacesEntity;*/

    public Connection getConnection() {
        if(connection == null) {
            try {
                connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSource2"))
                        .getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected UsersEntity getUsersEntity() {
        if(getConnection() != null) {
            if(usersEntity == null) {
                usersEntity = new UsersEntity();
                usersEntity.setConnection(getConnection());
            }
        }
        return usersEntity;
    }
/*
    protected WorkspacesEntity getCountriesEntity() {
        if(getConnection() != null) {
            if(workspacesEntity == null) {
                workspacesEntity = new WorkspacesEntity();
                workspacesEntity.setConnection(getConnection());
            }
        }
        return workspacesEntity;
    }
*/
    public List<User> findAllUsers() {
        return getUsersEntity() != null ?
                getUsersEntity().findAll() : null;
    }

    /*public List<Workspace> findAllWorkspaces() {
        return (getWorkspacesEntity() != null &&
                getUsersEntity() != null) ?
                getWorkspacesEntity().findAll(getUsersEntity()) : null;

    }*/
    public User findUserById(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().findById(id) : null;
    }

    public User findUserByName(String name) {
        return getUsersEntity() != null ?
                getUsersEntity().findByName(name) : null;
    }

    //esto de abajo es para obtener el usuario?
    public User createUser(String name,String lastname, String password, String email, int age, int dni) {
        return getUsersEntity() != null ?
                getUsersEntity().create(name,lastname,password,email,age,dni) : null;
    }

    public boolean deleteUser(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().delete(id) : false;
    }

    public boolean updateUser(User user) {
        return getUsersEntity() != null ?
                getUsersEntity().update(user) : false;
    }

    public User findUserByEmail(String email) {
        return getUsersEntity() != null ?
                getUsersEntity().findByEmail(email) : null;
    }

}
