package cn.lyj.generator.core.globConfig;

import cn.lyj.generator.common.exception.Error;
import cn.lyj.generator.common.exception.MyException;
import cn.lyj.generator.core.entity.GlobConfig;
import cn.lyj.generator.core.entity.JavaClass;
import cn.lyj.generator.core.entity.table.LTable;
import cn.lyj.generator.core.service.dbService.LJdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 11:24
 */
public class Configuration implements Serializable
{
    /**
     * <br>
     * jdbc
     */
    private LJdbc jdbc;

    private String dbName;

    private Connection connection;

    private GlobConfig globConfig;

    private JavaClass javaClass;

    /**
     * <br>
     * 表
     */
    private List<LTable> tables;

    public Configuration(LJdbc jdbc, GlobConfig globConfig, List<LTable> tables)
    {
        this(jdbc);
        this.globConfig = globConfig;
        this.tables = tables;
        this.javaClass = new JavaClass(globConfig.getProjectName());
    }

    public Configuration(LJdbc jdbc, GlobConfig globConfig)
    {
        this(jdbc);
        this.globConfig = globConfig;
        this.javaClass = new JavaClass(globConfig.getProjectName());
    }

    public JavaClass getJavaClass()
    {
        return javaClass;
    }

    public void setJavaClass(JavaClass javaClass)
    {
        this.javaClass = javaClass;
    }

    public Configuration(GlobConfig globConfig)
    {
        this.globConfig = globConfig;
    }

    public Configuration(List<LTable> tables)
    {
        this.tables = tables;
    }

    public Configuration(LJdbc jdbc)
    {
        if (jdbc == null)
        {
            throw new MyException(Error.参数为空异常);
        }
        this.jdbc = jdbc;
        this.connection = jdbc.getConnection();
        this.dbName = jdbc.getDbPropertis().getDbName();

    }

    public GlobConfig getGlobConfig()
    {
        return globConfig;
    }

    public void setGlobConfig(GlobConfig globConfig)
    {
        this.globConfig = globConfig;
    }

    public String getDbName()
    {
        return dbName;
    }

    public Connection getConnection()
    {
        return connection;
    }

    public LJdbc getJdbc()
    {
        return jdbc;
    }

    public void setJdbc(LJdbc jdbc)
    {
        this.jdbc = jdbc;
    }

    public List<LTable> getTables()
    {
        return tables;
    }

    public void setTables(List<LTable> tables)
    {
        this.tables = tables;
    }
}
