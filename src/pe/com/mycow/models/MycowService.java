package pe.com.mycow.models;

import java.sql.Connection;
import java.util.List;

public class MycowService {

    private Connection connection;
    private UsersEntity usersEntity;
    private WorkspacesEntity workspacesEntity;

    private Connection getConnection() {
        if(connection == null) {
            try {
                connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSource"))
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

    protected WorkspacesEntity getCountriesEntity() {
        if(getConnection() != null) {
            if(workspacesEntity == null) {
                workspacesEntity = new WorkspacesEntity();
                workspacesEntity.setConnection(getConnection());
            }
        }
        return workspacesEntity;
    }

    public List<User> findAllRegions() {
        return getUsersEntity() != null ?
                getUsersEntity().findAll() : null;
    }

    public List<Workspace> findAllWorkspaces() {
        return (getWorkspacesEntity() != null &&
                getUsersEntity() != null) ?
                getWorkspacesEntity().findAll(getUsersEntity()) : null;

    }
    public Region findRegionById(int id) {
        return getRegionsEntity() != null ?
                getRegionsEntity().findById(id) : null;
    }

    public Region findRegionByName(String name) {
        return getRegionsEntity() != null ?
                getRegionsEntity().findByName(name) : null;
    }

    public Region createRegion(String name) {
        return getRegionsEntity() != null ?
                getRegionsEntity().create(name) : null;
    }

    public boolean deleteRegion(int id) {
        return getRegionsEntity() != null ?
                getRegionsEntity().delete(id) : false;
    }

    public boolean updateRegion(Region region) {
        return getRegionsEntity() != null ?
                getRegionsEntity().update(region) : false;
    }


}
