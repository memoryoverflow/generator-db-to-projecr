package cn.lyj.generator.core.entity;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-05 18:47
 */
public class DbPropertis
{
    /**
     * <br>
     * 数据库
     */
    @NotBlank(message="数据库名称不能为空")
    private String dbName;

    /**
     * <br>
     * 账号
     */
    @NotBlank(message="数据库账户不能为空")
    private String dbRoot;

    /**
     * <br>
     * 账户密码
     */
    @NotBlank(message="数据库密码不能为空")
    private String dbPwd;

    /**
     * <br>
     * 数据库 host
     */
    @NotBlank(message="数据库连接地址")
    private String dbHost;

    /**
     * <br>
     * 数据库连接端口
     */
    @NotNull(message="数据库端口不能为空")
    private Integer dbPort;

    public DbPropertis(String dbName, String dbRoot, String dbPwd, String dbHost,Integer dbPort)
    {
        this.dbName = dbName;
        this.dbRoot = dbRoot;
        this.dbPwd = dbPwd;
        this.dbHost = dbHost;
        this.dbPort = dbPort;
    }

    public String getDriverClassName(){
        return "com.mysql.jdbc.Driver";
    }

    public String getUrl(){
        return "jdbc:mysql://"+this.dbHost+":"+this.getDbPort()+"/"+this.dbName+"?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
    }

    public String getDbName()
    {
        return dbName;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    public String getDbRoot()
    {
        return dbRoot;
    }

    public void setDbRoot(String dbRoot)
    {
        this.dbRoot = dbRoot;
    }

    public String getDbPwd()
    {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd)
    {
        this.dbPwd = dbPwd;
    }

    public String getDbHost()
    {
        return dbHost;
    }

    public void setDbHost(String dbHost)
    {
        this.dbHost = dbHost;
    }

    public Integer getDbPort()
    {
        return dbPort;
    }

    public void setDbPort(Integer dbPort)
    {
        this.dbPort = dbPort;
    }
}
