package pe.com.mycow.models;

import java.sql.Connection;
import java.util.List;

public class MycowService {
  
    private Connection connection;
    private UsersEntity usersEntity;

    public Connection getConnection() {

        return connection;
    }

    public void setConnection(Connection connection) {

        this.connection = connection;
    }

    public UsersEntity getUsersEntity() {
        if(getConnection() != null){
            if(usersEntity == null){
                usersEntity = new UsersEntity();
                usersEntity.setConnection(getConnection());
            }
        }
        return usersEntity;
    }
  
    public List<User> findAllUsers(){

        return getUsersEntity() != null ? getUsersEntity().findALL() : null;
    }
  
    public User findUserById(int id){

        return getUsersEntity() != null ? getUsersEntity().findById(id) : null;
    }

    public User createUser(String name){
        
        return getUsersEntity() != null ?  getUsersEntity().create(name): null;
    }

    public boolean deleteUser( int id) {

        return getUsersEntity() != null ? getUsersEntity().delete(id) : false;
    }

    public  boolean updateUser(User user){
        
        return getUsersEntity() != null ? getUsersEntity().update(user) : false;
    }


}
