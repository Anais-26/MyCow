package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{
  
  private static String DEFAULT_SQL = "SELECT * FROM mycow.users";

    private List<User> findByCriteria(String sql) {
        List<User> users;

        if (getConnection() != null) {
            users = new ArrayList<>();
          
          try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    User user = new User().setId(resultSet.getInt("user_id"))
                            .setName(resultSet.getString("user_name"));
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

    public List<User> findALL() {
        return findByCriteria(DEFAULT_SQL);
    }
  
      public User findById(int id){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE user_id = "+String.valueOf(id));
        return(users != null ? users.get(0) : null);
    }

    public User findByName(String name){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE user_name = '"+name + "'");
        return(users != null ? users.get(0) : null);
    }

    public User findAll(String name){
        List<User> users = findByCriteria(DEFAULT_SQL+"WHERE user_name = '"+name + "'");
        return(users != null ? users.get(0) : null);
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

    private int getId(){
        String sql = "SELECT(user_id) AS id FROM users ";

        if(getConnection() != null){
            ResultSet resultSet = null;
            try {
                resultSet = getConnection().createStatement().executeQuery(sql);
                return resultSet.next() ? resultSet.getInt("id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public  User create(String name){
        if(findByName(name) == null){
            if(getConnection() != null){
                String sql = "INSERT INTO users(user_id,user_name)" +"VALUES(" + String.valueOf(getId()) + ", '"+name+"')";
                int results = updatebycriteria(sql);
                if(results > 0){
                    User user = new User();
                    return user;
                }
            }
        }
        return null;
    }
  
  public boolean delete(int id){

        return updatebycriteria("DELETE FROM users WHERE user_id =" + String.valueOf(id)) > 0;
    }

    public boolean delete(String name){

        return updatebycriteria("DELETE FROM users WHERE user_name = '" + name + "'") > 0;
    }

    public boolean update(User user){

        return updatebycriteria("UPDATE users SET user_name = '"+ user.getName()+ "' WHERE region_id ="+ String.valueOf(getId())) > 0;

    }
                     
}
