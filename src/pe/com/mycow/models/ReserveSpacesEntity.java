package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveSpacesEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM hr.reservespaces";
    private List<ReserveSpace> findByCriteria(String sql) {
        List<ReserveSpace> reserveSpaces;
        if(getConnection() != null) {
            reserveSpaces = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    ReserveSpace reservespace = new ReserveSpace()
                            .setId(resultSet.getInt("reservespace_id"))
                            .setReservationDate(resultSet.getString("reserverspace_reservationdate"))
                            .setNumHours(resultSet.getInt("reservespace_numhours"))
                            .setNumDays(resultSet.getInt("reservespace_numdays"));
                    reserveSpaces.add(reservespace);
                }
                return reserveSpaces;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<ReserveSpace> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public ReserveSpace findById(int id) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE reservespace_id = "+ String.valueOf(id));
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }

    public ReserveSpace findByReservationDate(String date) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE reservespace_reservationdate = '" + date + "'");
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }


    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM reservespaces WHERE reservespace_id = " + String.valueOf(id)) > 0;
    }
}
