package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkplacesEntity extends BaseEntity {

    private static String DEFAULT_SQL = "SELECT * FROM mycow.workplaces";
    private List<Workplace> findByCriteria(String sql) {
        List<Workplace> workplaces;
        if(getConnection() != null) {
            workplaces = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Workplace workplace = new Workplace()
                            .setId(resultSet.getInt("reserveplace_id"));
                    workplaces.add(workplace);
                }
                return workplaces;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }

        return
                null;
    }

}
