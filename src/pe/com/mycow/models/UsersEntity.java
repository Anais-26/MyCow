package pe.com.mycow.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{
  
  private static String DEFAULT_SQL = "SELECT * FROM users";

    private List<User> findByCriteria(String sql) {
        List<User> users;

        if (getConnection() != null) {
            users = new ArrayList<>();
          
          try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    User user = new User().setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setLastName(resultSet.getString("lastname"))
                            .setPassword(resultSet.getString("password"))
                            .setEmail(resultSet.getString("email"))
                            .setAge(resultSet.getInt("age"))
                            .setDni(resultSet.getInt("dni"));
                    users.add(user);                  
                }
                return users;

            } 
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public List<User> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }
  
      public User findById(int id){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE id = "+String.valueOf(id));
        return(users != null && !users.isEmpty() ? users.get(0) : null);
    }

    public User findByName(String name){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE name = '"+name + "'");
        return(users != null && !users.isEmpty() ? users.get(0) : null);
    }

    private  int updatebycriteria(String sql){
        if(getConnection() != null){
            try {
                return  getConnection().createStatement().executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM users";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public  User create(String name, String lastname, String password, String email, int age, int dni){
        if (findByEmail(email) == null) {
        if(findByName(name) == null) {
                if (getConnection() != null) {
                    String sql = "INSERT INTO users(id, name,lastname,password,email,age,dni) VALUES(" +
                            String.valueOf(getMaxId() + 1) + ", '" +
                            name + ", '" + lastname + ", '" + password + ", '" + email + ", '" + age + ", '"
                            + dni + "')";
                    int results = updatebycriteria(sql);
                    if (results > 0) {
                        User user = new User(getMaxId(), name, lastname, password, email, age, dni);
                        return user;
                    }
                }
            }
            return null;
        }
        return null;
    }
  
  public boolean delete(int id){

        return updatebycriteria("DELETE FROM users WHERE id =" + String.valueOf(id)) > 0;
    }
/*
    public boolean delete(String name){

        return updatebycriteria("DELETE FROM users WHERE name = '" + name + "'") > 0;
    }
*/
    public boolean update(User user){
        if(findByName(user.getName()) != null) return false;
        return updatebycriteria("UPDATE users SET name = '" +
                user.getName() + "' " + "SET lastname = '"+ user.getLastName()+
                "SET password = '"+ user.getPassword()+ "SET email = '"+ user.getEmail()+
                "SET age = '"+ user.getAge()+ "SET dni = '"+ user.getDni()+
                "WHERE id = " + String.valueOf(user.getId())) > 0;

    }

    public User findByEmail(String email){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE email = '"+email+ "'");
        return(users != null && !users.isEmpty() ? users.get(0) : null);
    }
/*
    public boolean isEmailRegister(String email) {
        if (getConnection() != null) {
            String sql = "SELECT * FROM user WHERE email='" + email + "'";

            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);

                return resultSet.next();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return true;

    }
/*
    public User LogIn(){
        User user = null;
        String consulta;
        try{

            consulta = "SELECT * FROM users(

        }
        catch (Exception e){
            throw e;
        }
        finally {

        }
        return user;
    }

*/
}
