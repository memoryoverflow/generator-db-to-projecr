package cn.lyj.generator.core.service.dbService;

import cn.lyj.generator.common.exception.Error;
import cn.lyj.generator.common.exception.MyException;
import cn.lyj.generator.core.entity.DbPropertis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * <br>
 *
 * @author 永健
 * @since 2019/5/7 14:30
 */
public class LJdbc
{
    private static Logger logger = LoggerFactory.getLogger(LJdbc.class);

    private DbPropertis dbPropertis;

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public LJdbc(DbPropertis dbPropertis)
    {
        this.dbPropertis = dbPropertis;
        getConnection();
    }

    public Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                Class.forName(this.dbPropertis.getDriverClassName());
                logger.info("@_@!  数据库驱动加载成功");
                connection = DriverManager.getConnection(this.dbPropertis.getUrl(), this.dbPropertis.getDbRoot(), this.dbPropertis.getDbPwd());
                connection.setAutoCommit(false);
                logger.info("-----------  @_@!  数据库连接成功  -----------");
            }
            catch (Exception e)
            {
                logger.error("@_@!  数据库连接失败," + e);
                e.printStackTrace();
                throw new MyException(Error.数据库连接异常, e.getMessage());
            }
        }
        return connection;
    }


    private PreparedStatement getPreparedStatement(String sql)
    {
        try
        {
            return getConnection().prepareStatement(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String sql) throws SQLException
    {
        return getPreparedStatement(sql).executeUpdate();
    }

    public ResultSet executeQuery(String sql)
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = getPreparedStatement(sql).executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            logger.error(sql);
        }
        return resultSet;
    }


    public PreparedStatement executePreparedStatement(String sql)
    {
        return getPreparedStatement(sql);
    }

    public void close()
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }

            if (preparedStatement != null)
            {
                preparedStatement.close();
            }

            logger.info("------------  关闭数据库连接 ---------------");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public DbPropertis getDbPropertis()
    {
        return dbPropertis;
    }

}
