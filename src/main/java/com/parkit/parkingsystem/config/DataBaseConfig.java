package com.parkit.parkingsystem.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Data base config.
 */
public class DataBaseConfig {

  private static final Logger logger = LogManager.getLogger("DataBaseConfig");

  /**
   * Gets connection.
   *
   * @return the connection
   * @throws ClassNotFoundException the class not found exception
   * @throws SQLException           the sql exception
   */
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    logger.info("Create DB connection");
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/prod", "userbdd", "mdp12345!");
  }

  /**
   * Close connection.
   *
   * @param con the connection
   */
  public void closeConnection(Connection con) {
    if (con != null) {
      try {
        con.close();
        logger.info("Closing DB connection");
      } catch (SQLException e) {
        logger.error("Error while closing connection", e);
      }
    }
  }

  /**
   * Close prepared statement.
   *
   * @param ps the prepared statement
   */
  public void closePreparedStatement(PreparedStatement ps) {
    if (ps != null) {
      try {
        ps.close();
        logger.info("Closing Prepared Statement");
      } catch (SQLException e) {
        logger.error("Error while closing prepared statement", e);
      }
    }
  }

  /**
   * Close result set.
   *
   * @param rs the result set
   */
  public void closeResultSet(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
        logger.info("Closing Result Set");
      } catch (SQLException e) {
        logger.error("Error while closing result set", e);
      }
    }
  }
}
