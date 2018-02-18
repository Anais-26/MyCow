package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkspacesEntity extends BaseEntity{

    private static String DEFAULT_SQL = "SELECT * FROM mycow.workspaces";

    private List<Workspace> findByCriteria(String sql) {
        List<Workspace> workspaces;

        if (getConnection() != null) {
            workspaces = new ArrayList<>();

            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Workspace workspace = new Workspace().setId(resultSet.getInt("workspace_id"));
                    workspaces.add(workspace);
                }
                return workspaces;

            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


}
