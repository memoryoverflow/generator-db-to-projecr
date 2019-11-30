package cn.lyj.generator.core.entity.table;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 10:25
 */
public class LTable
{
    /**
     * <br>
     * 表名字
     */
    private String tableName;

    /**
     * <br>
     * 实体名 不包含后缀
     */
    private String entityName;

    /**
     * <br>
     * service
     */
    private String serviceName;

    /**
     * <br>
     * 实现
     */
    private String serviceImplName;

    /**
     * <br>
     * 控制
     */
    private String controllerName;

    /**
     * <br>
     * 接口
     */
    private String mapperName;

    /**
     * <br>
     *  xml
     */
    private String mappeerXmlName;


    /**
     * <br>
     * controller 访问跟路径
     */
    private String basePath;



    /**
     * <br>
     * 表注释
     */
    private String comment;

    /**
     * <br>
     * 数据库的列
     */
    private List<Field> fields;


    public String getBasePath()
    {
        return basePath;
    }

    public void setBasePath(String basePath)
    {
        this.basePath = basePath;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getMapperName()
    {
        return mapperName;
    }

    public void setMapperName(String mapperName)
    {
        this.mapperName = mapperName;
    }

    public String getEntityName()
    {
        return entityName;
    }

    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getServiceImplName()
    {
        return serviceImplName;
    }

    public void setServiceImplName(String serviceImplName)
    {
        this.serviceImplName = serviceImplName;
    }

    public String getControllerName()
    {
        return controllerName;
    }

    public void setControllerName(String controllerName)
    {
        this.controllerName = controllerName;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public List<Field> getFields()
    {
        return fields;
    }

    public void setFields(List<Field> fields)
    {
        this.fields = fields;
    }

    public String getMappeerXmlName()
    {
        return mappeerXmlName;
    }

    public void setMappeerXmlName(String mappeerXmlName)
    {
        this.mappeerXmlName = mappeerXmlName;
    }
}
