package test.code.generator.db;


import test.code.generator.utils.ConfigUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 *
 * @author GreedyStar
 * @since 2018/4/19
 */
public class ConnectionUtil {
    /**
     * 数据库连接
     */
    private Connection connection;

    /**
     * 初始化数据库连接
     *
     * @return 连接是否建立成功
     */
    public boolean initConnection() {
        try {
            Class.forName(test.code.generator.db.DataBaseFactory.getDriver(ConfigUtil.getConfiguration().getDb().getUrl()));
            String url = ConfigUtil.getConfiguration().getDb().getUrl();
            String username = ConfigUtil.getConfiguration().getDb().getUsername();
            String password = ConfigUtil.getConfiguration().getDb().getPassword();
            Properties properties = new Properties();
            properties.put("user", username);
            properties.put("password", password == null ? "" : password);
            properties.setProperty("remarks", "true");
            properties.setProperty("useInformationSchema", "true");
            properties.setProperty("nullCatalogMeansCurrent", "true");
            connection = DriverManager.getConnection(url, properties);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 关闭数据库连接
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

}
