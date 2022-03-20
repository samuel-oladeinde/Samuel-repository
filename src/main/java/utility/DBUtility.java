package utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtility {

    private String dbUrl;
    private String username;
    private String password;
    private Connection connect;

    /*
    public DBUtility() {
        try {
            Properties environmentProperties = PropertyFileUtility.propertyFile("");
            dbUrl = environmentProperties.getProperty("dbUrl");
            username = environmentProperties.getProperty("username");
            password = environmentProperties.getProperty("password");
            connect = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
        }
    }

    public void closeDbConnection() {
        try {
            connect.close();
            //logUtility.logDebug("DB connection is closed.");
        } catch (Exception e) {
            //  logUtility.logException(ExceptionUtils.getStackTrace(e));
        }
    }

    public void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            // logUtility.logException(ExceptionUtils.getStackTrace(e));
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        Statement statement = null;
        try {
            statement = connect.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            //  logUtility.logException(ExceptionUtils.getStackTrace(e));
        }
        return rs;
    }

    public void updateQuery(String query) throws SQLException {
        int rs = 0;
        Statement statement = null;
        statement = connect.createStatement();
        rs = statement.executeUpdate(query);

    }

    public int getMakeId(String makeName) throws SQLException {
        int makeId = 0;
        String sqlQuery = "SELECT make_id  FROM `make` WHERE `make_name` LIKE  '" + makeName.toUpperCase() + "'";
        ResultSet rs = executeQuery(sqlQuery);
        while (rs.next()) {
            makeId = rs.getInt("make_id");
        }
        closeResultSet(rs);
        return makeId;
    }

    public int getModelId(String modelName) throws SQLException {
        int modelId = 0;
        String sqlQuery = "SELECT model_id FROM model WHERE model_name= '" + modelName.toUpperCase() + "'";
        ResultSet rs = executeQuery(sqlQuery);
        while (rs.next()) {
            modelId = rs.getInt("model_id");
        }
        closeResultSet(rs);

        return modelId;
    }

    public int getVariantId(String variantName, String modelName) throws SQLException {
        int variantId = 0;

        String sqlQuery = "SELECT variant_id FROM variant where variant_name='" + variantName.toUpperCase() + "' and model_id=" + getModelId(modelName);
        ResultSet rs = executeQuery(sqlQuery);
        while (rs.next()) {
            variantId = rs.getInt("variant_id");
        }
        closeResultSet(rs);

        return variantId;
    }

    public String getUserToken(String dealerEmail) throws SQLException {
        String userToken = null;

        String sqlQuery = "SELECT user_token FROM `app_user_token` WHERE IsActiveDevice = 1 AND is_logged_in = 1 AND `user_email` LIKE '" + dealerEmail + "'";
        ResultSet rs = executeQuery(sqlQuery);
        while (rs.next()) {
            userToken = rs.getString(1);
        }
        closeResultSet(rs);

        return userToken;
    }

    public String getAnyToken(String dealerEmail) throws SQLException {
        String userToken = null;

        String sqlQuery = "SELECT user_token FROM `app_user_token` WHERE `user_email` LIKE '" + dealerEmail + "'";
        ResultSet rs = executeQuery(sqlQuery);
        while (rs.next()) {
            userToken = rs.getString(1);
        }
        closeResultSet(rs);

        return userToken;
    }

    //NOTE: This will work only if the dealer has logged in at least once so that its token is created.
    public String getDealerId(String dealerEmail) throws SQLException {
        String dealerId = null;

        String sqlQuery = "SELECT fk_dealer_id FROM `app_user_token` WHERE `user_email` LIKE '" + dealerEmail + "'";
        ResultSet rs = executeQuery(sqlQuery);
        while (rs.next()) {
            dealerId = rs.getString(1);
        }
        closeResultSet(rs);

        return dealerId;
    }

    public List<String> getActiveUserTokenIds(String dealerEmail) throws SQLException {
        List<String> activeUserTokenIds = new ArrayList<>();

        String sqlQuery = "SELECT app_user_token_id FROM `app_user_token` WHERE IsActiveDevice = 1 AND is_logged_in = 1 AND `user_email` LIKE '" + dealerEmail + "'";
        ResultSet rs = executeQuery(sqlQuery);
        while (rs.next()) {
            activeUserTokenIds.add(rs.getString(1));
        }
        closeResultSet(rs);

        return activeUserTokenIds;
    }

    public List<String> getPushTokenIds(List<String> userTokenIds) throws SQLException {
        List<String> activeUserTokenIds = new ArrayList<>();

        for (String userTokenId : userTokenIds) {
            String sqlQuery = "SELECT id_app_push_token FROM `app_user_push_token` WHERE id_app_user_token LIKE '" + userTokenId + "'";
            ResultSet rs = executeQuery(sqlQuery);
            while (rs.next()) {
                activeUserTokenIds.add(rs.getString(1));
            }
            closeResultSet(rs);
        }
        return activeUserTokenIds;
    }

     */
}

